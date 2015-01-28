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
package org.test.ext.dialog.client.custom;

import com.codenvy.ide.ui.dialogs.CancelCallback;
import com.codenvy.ide.ui.dialogs.InputCallback;
import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created by susinda on 1/26/15.
 */

public class StudentDialogPresenter implements StudentDialog, StudentDialogView.ActionDelegate {

    /** This component view. */
    private final StudentDialogView view;

    /** The callback used on OK. */
    private final InputCallback inputCallback;

    /** The callback used on cancel. */
    private final CancelCallback cancelCallback;


    @Inject
    public StudentDialogPresenter(final @Nonnull StudentDialogView view,
                                  final @Nullable @Assisted InputCallback inputCallback,
                                  final @Nullable @Assisted CancelCallback cancelCallback) {
        this.view = view;
        this.inputCallback = inputCallback;
        this.cancelCallback = cancelCallback;
        this.view.setDelegate(this);
    }

    @Override
    public void cancelled() {
        this.view.closeDialog();
        if (this.cancelCallback != null) {
            this.cancelCallback.cancelled();
        }
    }

    @Override
    public void accepted() {
        this.view.closeDialog();
        if (this.inputCallback != null) {
            this.inputCallback.accepted(view.getName());
        }
    }

    @Override
    public void show() {
        this.view.showDialog();
    }

}