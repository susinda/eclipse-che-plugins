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
package org.test.ext.dialog.client;

import com.codenvy.ide.api.action.Action;
import com.codenvy.ide.api.action.ActionEvent;

import com.codenvy.ide.ui.dialogs.CancelCallback;
import com.codenvy.ide.ui.dialogs.DialogFactory;
import com.codenvy.ide.ui.dialogs.InputCallback;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import org.test.ext.dialog.client.custom.StudentDialogPresenter;
import org.test.ext.dialog.client.custom.StudentDialogView;

/**
 * Created by susinda on 1/26/15.
 */
public class TestDialogAction extends Action{

    private DialogFactory dialogFactory;
    private StudentDialogView view;

    @Inject
    public TestDialogAction(DialogFactory dialogFactory, StudentDialogView view) {

        super("TEST Dialog", "Test Dialog Description");
        this.dialogFactory = dialogFactory;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //InputDialog inputDialog = dialogFactory.createInputDialog("Test Title", "Test Message", new InputCallback() {
        StudentDialogPresenter inputDialog = new StudentDialogPresenter(view, new InputCallback() {
            @Override
            public void accepted(String value) {
                Window.alert("User input was: " + value);
            }
        }, new CancelCallback() {
            @Override
            public void cancelled() {
                Window.alert("Canceled by user");
            }
        });
        inputDialog.show();
    }
}
