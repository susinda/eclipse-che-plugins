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
package org.wso2.developerstudio.codenvy.ext.esb.client;

/**
 * @author Evgen Vidolob
 */

import com.codenvy.ide.api.editor.EditorRegistry;
import com.codenvy.ide.api.extension.Extension;
import com.codenvy.ide.api.filetypes.FileType;
import com.codenvy.ide.api.filetypes.FileTypeRegistry;
import com.codenvy.ide.api.projecttype.wizard.ProjectTypeWizardRegistry;
import com.codenvy.ide.api.projecttype.wizard.ProjectWizard;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import org.wso2.developerstudio.codenvy.ext.esb.client.editor.multipage.ESBMultiPageEditorProvider;
import org.wso2.developerstudio.codenvy.ext.esb.client.wizard.ESBConfigurationPresenter;
import org.wso2.developerstudio.codenvy.ext.esb.shared.ESBProjectConstants;

@Singleton
@Extension(title = "WSO2 ESB extension", description = "WSO2 ESB extension", version = "1.0.0")
public class ESBExtension {

    @Inject
    public ESBExtension(ProjectWizard projectWizard,
                        Provider<ESBConfigurationPresenter> wizardPage,
                        ProjectTypeWizardRegistry registry,
                        FileTypeRegistry fileTypeRegistry,
                        @Named("wso2ESBFile") FileType dssFileType,
                        ESBMultiPageEditorProvider editorProvider,
                        EditorRegistry editorRegistry) {

        projectWizard.addPage(wizardPage);

        registry.addWizard(ESBProjectConstants.PROJECT_ID, projectWizard);

        fileTypeRegistry.registerFileType(dssFileType);
        editorRegistry.registerDefaultEditor(dssFileType, editorProvider);
    }

}
