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
 * Created by Evgen on 1/22/15.
 */
package org.wso2.developerstudio.codenvy.ext.esb.client.editor.multipage;

import com.codenvy.ide.api.editor.EditorPartPresenter;
import com.codenvy.ide.jseditor.client.texteditor.ConfigurableTextEditor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Evgen Vidolob
 */
public class ESBMultiPageEditorViewImpl extends Composite implements ESBMultiPageEditorView {

    interface DBSMultiPageEditorViewImplUiBinder
            extends UiBinder<Widget, ESBMultiPageEditorViewImpl> {
    }

    private static DBSMultiPageEditorViewImplUiBinder ourUiBinder = GWT.create(DBSMultiPageEditorViewImplUiBinder.class);
    @UiField
    Button          showTextEditor;
    @UiField
    Button          showGraphicalEditor;
    @UiField
    SimplePanel     textEditor;
    @UiField
    SimplePanel     graphicalEditor;
    @UiField
    DockLayoutPanel pages;

    private ActionDelegate delegate;

    @Inject
    public ESBMultiPageEditorViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public void showTextEditor() {
        pages.setWidgetHidden(graphicalEditor, true);

        pages.setWidgetHidden(textEditor, false);
        pages.setWidgetSize(textEditor, 100);
    }

    @Override
    public void showGraphicalEditor() {
        pages.setWidgetHidden(graphicalEditor, false);

        pages.setWidgetHidden(textEditor, true);
        pages.setWidgetSize(textEditor, 0);
    }

    @Override
    public void addTextEditor(ConfigurableTextEditor editor) {
        editor.go(textEditor);
    }

    @Override
    public void addGraphicalEditor(EditorPartPresenter editor) {
        editor.go(graphicalEditor);
    }

    @Override
    public void setDelegate(ActionDelegate delegate) {
        this.delegate = delegate;
    }

    @UiHandler("showTextEditor")
    public void onTextEditorChosen(ClickEvent event) {
        delegate.onTextEditorChosen();
    }

    @UiHandler("showGraphicalEditor")
    public void onGraphicalEditorChosen(ClickEvent event) {
        delegate.onGraphicalEditorChosen();
    }

}