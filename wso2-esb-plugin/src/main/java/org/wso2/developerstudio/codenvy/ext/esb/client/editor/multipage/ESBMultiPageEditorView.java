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
import com.codenvy.ide.api.mvp.View;
import com.codenvy.ide.jseditor.client.texteditor.ConfigurableTextEditor;
import com.google.inject.ImplementedBy;

/**
 * @author Evgen Vidolob
 */
@ImplementedBy(ESBMultiPageEditorViewImpl.class)
public interface ESBMultiPageEditorView extends View<ESBMultiPageEditorView.ActionDelegate> {

    void showTextEditor();

    void showGraphicalEditor();

    void addTextEditor(ConfigurableTextEditor editor);

    void addGraphicalEditor(EditorPartPresenter editor);

    interface ActionDelegate {
        void onTextEditorChosen();

        void onGraphicalEditorChosen();
    }

}
