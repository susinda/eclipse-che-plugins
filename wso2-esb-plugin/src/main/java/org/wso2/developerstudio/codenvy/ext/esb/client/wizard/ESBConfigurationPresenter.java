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

import com.codenvy.api.project.shared.dto.GeneratorDescription;
import com.codenvy.api.project.shared.dto.ProjectDescriptor;
import com.codenvy.ide.api.projecttype.wizard.ProjectWizard;
import com.codenvy.ide.api.wizard.AbstractWizardPage;
import com.codenvy.ide.dto.DtoFactory;
import com.codenvy.ide.ui.dialogs.CancelCallback;
import com.codenvy.ide.ui.dialogs.DialogFactory;
import com.codenvy.ide.ui.dialogs.InputCallback;
import com.codenvy.ide.ui.dialogs.input.InputDialog;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import org.wso2.developerstudio.codenvy.ext.esb.shared.ESBProjectConstants;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Evgen Vidolob
 */
public class ESBConfigurationPresenter extends AbstractWizardPage implements ESBConfigurationView.ActionDelegate {

    private final ESBConfigurationView view;
    private final DtoFactory dtoFactory;
    private final DialogFactory factory;

    @Inject
    public ESBConfigurationPresenter(ESBConfigurationView view, DtoFactory dtoFactory, com.codenvy.ide.ui.dialogs.DialogFactory factory) {
        super(null, null);
        this.view = view;
        this.dtoFactory = dtoFactory;
        this.factory = factory;
        view.setDelegate(this);
    }

    @Nullable
    @Override
    public String getNotice() {
        return null;
    }

    @Override
    public boolean isCompleted() {
        return !(view.getGroupId().isEmpty() ||
                 view.getArtifactId().isEmpty() ||
                 view.getVersion().isEmpty());
    }

    @Override
    public void focusComponent() {

    }

    @Override
    public void storeOptions() {
        Map<String, List<String>> attributes = getAttributes();

        attributes.put(ESBProjectConstants.GROUP_ID, Arrays.asList(view.getGroupId()));
        attributes.put(ESBProjectConstants.ARTIFACT_ID, Arrays.asList(view.getArtifactId()));
        attributes.put(ESBProjectConstants.VERSION, Arrays.asList(view.getVersion()));

        GeneratorDescription generator =
                dtoFactory.createDto(GeneratorDescription.class).withName(ESBProjectConstants.GENERATOR_ID);

        wizardContext.putData(ProjectWizard.GENERATOR, generator);

    }

    private Map<String, List<String>> getAttributes() {
        ProjectDescriptor project = wizardContext.getData(ProjectWizard.PROJECT);

        if (project == null) {
            throw new IllegalStateException("Some problem happened");
        }

        return project.getAttributes();
    }

    @Override
    public void removeOptions() {
        Map<String, List<String>> attributes = getAttributes();
        attributes.remove(ESBProjectConstants.GROUP_ID);
        attributes.remove(ESBProjectConstants.ARTIFACT_ID);
        attributes.remove(ESBProjectConstants.VERSION);

        wizardContext.removeData(ProjectWizard.GENERATOR);
    }

    @Override
    public void go(AcceptsOneWidget container) {
        view.setGroupId("");
        view.setArtifactId("");
        view.setVersion("");

        container.setWidget(view);
    }

    @Override
    public void onGroupIdChanged() {
        delegate.updateControls();
    }

    @Override
    public void onArtifactIdChanged() {
        delegate.updateControls();
    }

    @Override
    public void onVersionChanged() {
        delegate.updateControls();
    }


}
