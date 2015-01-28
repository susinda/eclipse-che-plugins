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

import com.codenvy.ide.ui.window.Window;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * Created by susinda on 1/26/15.
 */
public class StudentDialogViewImpl extends Window implements StudentDialogView{

    @UiField
    TextBox txtGraduate;
    @UiField
    TextBox txtAge;
    @UiField
    TextBox txtName;

    private ActionDelegate delegate;

    interface StudentDialogViewImplUiBinder extends UiBinder<Widget, StudentDialogViewImpl> {
    }

    private static StudentDialogViewImplUiBinder ourUiBinder = GWT.create(StudentDialogViewImplUiBinder.class);


    @Inject
    public StudentDialogViewImpl() {
        Widget rootElement = ourUiBinder.createAndBindUi(this);
        setWidget(rootElement);

    }

    @Override
    public void setDelegate(ActionDelegate delegate) {
        this.delegate = delegate;
    }

    @Override
    public void showDialog() {
        this.show();
    }

    @Override
    public void closeDialog() {
        this.hide();
    }

    @Override
    public void setName(String name) {
        this.txtName.setText(name);
    }

    @Override
    public String getName() {
        return this.txtName.getValue();
    }

    @Override
    public void setAge(String age) {
        this.txtAge.setText(age);
    }

    @Override
    public String getAge() {
        return this.txtAge.getValue();
    }

    @Override
    public void setIsGraduate(String graduate) {
        this.txtGraduate.setValue(graduate);
    }

    @Override
    public String isGraduate() {
        return this.txtGraduate.getValue();
    }

    @Override
    public void showErrorHint(String message) {

    }

    @Override
    public void hideErrorHint() {

    }
    //Window override method
    @Override
    protected void onClose() {

    }


    //Ui events
    @UiHandler("txtName")
    void onKeyUp(KeyUpEvent event) {

    }
}