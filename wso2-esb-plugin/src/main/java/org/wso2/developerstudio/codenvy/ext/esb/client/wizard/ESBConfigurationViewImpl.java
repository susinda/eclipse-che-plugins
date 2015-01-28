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
 * Created by Evgen on 1/20/15.
 */
package org.wso2.developerstudio.codenvy.ext.esb.client.wizard;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

/**
 * @author Evgen Vidolob
 */
public class ESBConfigurationViewImpl extends Composite implements ESBConfigurationView {


    interface ESBConfigurationViewImplUiBinder
            extends UiBinder<Widget, ESBConfigurationViewImpl> {

    }

    private static ESBConfigurationViewImplUiBinder ourUiBinder = GWT.create(ESBConfigurationViewImplUiBinder.class);

    private ActionDelegate delegate;
    @UiField
    TextBox groupId;
    @UiField
    TextBox artifactId;
    @UiField
    TextBox version;


    @Inject
    public ESBConfigurationViewImpl() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public void setDelegate(ActionDelegate delegate) {

        this.delegate = delegate;
    }

    @Override
    public String getGroupId() {
        return groupId.getText();
    }

    @Override
    public void setGroupId(String groupId) {
        this.groupId.setText(groupId);
    }


    @Override
    public String getArtifactId() {
        return artifactId.getText();
    }

    @Override
    public void setArtifactId(String artifactId) {
        this.artifactId.setText(artifactId);
    }


    @Override
    public String getVersion() {
        return version.getText();
    }

    @Override
    public void setVersion(String version) {
        this.version.setText(version);
    }


    @UiHandler("groupId")
    public void onGroupIdChanged(KeyUpEvent event) {
        delegate.onGroupIdChanged();
    }

    @UiHandler("artifactId")
    public void onArtifactIdChanged(KeyUpEvent event) {
        delegate.onArtifactIdChanged();
    }

    @UiHandler("version")
    public void onVersionChanged(KeyUpEvent event) {
        delegate.onVersionChanged();
    }

}