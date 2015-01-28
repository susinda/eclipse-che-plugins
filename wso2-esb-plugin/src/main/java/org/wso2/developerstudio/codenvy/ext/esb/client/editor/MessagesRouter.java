/*******************************************************************************
 * Copyright (c) 2012-2014 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/

/**
 * Created by Evgen on 1/21/15.
 */
package org.wso2.developerstudio.codenvy.ext.esb.client.editor;

import elemental.client.Browser;
import elemental.events.Event;
import elemental.events.EventListener;
import elemental.events.MessageEvent;

import com.codenvy.ide.api.editor.EditorAgent;
import com.codenvy.ide.api.editor.EditorPartPresenter;
import com.codenvy.ide.collections.StringMap;
import com.google.gwt.webworker.client.messages.MessageFilter;
import com.google.gwt.webworker.client.messages.MessageImpl;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.wso2.developerstudio.codenvy.ext.esb.client.editor.WSO2IFrameEditor;
import org.wso2.developerstudio.codenvy.ext.esb.client.messages.DirtyStateChangedMessage;
import org.wso2.developerstudio.codenvy.ext.esb.client.messages.SaveContentMessage;

/**
 * @author Evgen Vidolob
 */
@Singleton
public class MessagesRouter {

    private final EditorAgent editorAgent;
    private final MessageFilter filter;

    @Inject
    public MessagesRouter(final EditorAgent editorAgent) {
        this.editorAgent = editorAgent;
        filter = new MessageFilter();
        filter.registerMessageRecipient(3, new MessageFilter.MessageRecipient<SaveContentMessage>() {
            @Override
            public void onMessageReceived(final SaveContentMessage message) {
                editorAgent.getOpenedEditors().iterate(new StringMap.IterationCallback<EditorPartPresenter>() {
                    @Override
                    public void onIteration(String key, EditorPartPresenter value) {
                        if(message.getFilePath().equals(key) && value instanceof WSO2IFrameEditor){
                            WSO2IFrameEditor editor = ((WSO2IFrameEditor)value);
                                    editor.saveContent(message.getContent());
                        }
                    }
                });
            }
        });

        filter.registerMessageRecipient(4, new MessageFilter.MessageRecipient<DirtyStateChangedMessage>() {
            @Override
            public void onMessageReceived(final DirtyStateChangedMessage message) {
                editorAgent.getOpenedEditors().iterate(new StringMap.IterationCallback<EditorPartPresenter>() {
                    @Override
                    public void onIteration(String key, EditorPartPresenter value) {
                        if(message.getFilePath().equals(key) && value instanceof WSO2IFrameEditor){
                            WSO2IFrameEditor editor = ((WSO2IFrameEditor)value);
                            editor.setDirtyState(message.isDirty());
                        }
                    }
                });
            }
        });

        Browser.getWindow().addEventListener("message", new EventListener() {
            @Override
            public void handleEvent(Event evt) {
                MessageEvent messageEvent = (MessageEvent)evt;
                MessageImpl message = (MessageImpl)messageEvent.getData();
                filter.dispatchMessage(message);
            }
        }, false);


    }
}
