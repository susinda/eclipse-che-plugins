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
package org.wso2.developerstudio.codenvy.ext.esb.server.project.type;

import com.codenvy.api.project.server.Attribute;
import com.codenvy.api.project.server.Builders;
import com.codenvy.api.project.server.ProjectTemplateDescription;
import com.codenvy.api.project.server.ProjectType;
import com.codenvy.api.project.server.ProjectTypeDescriptionRegistry;
import com.codenvy.api.project.server.ProjectTypeExtension;
import com.codenvy.api.project.server.Runners;
import com.codenvy.api.project.shared.Constants;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.wso2.developerstudio.codenvy.ext.esb.shared.ESBProjectConstants;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author Evgen Vidolob
 */
@Singleton
public class ESBProjectTypeExtension implements ProjectTypeExtension {

    private final ProjectType projectType;

    @Inject
    public ESBProjectTypeExtension(ProjectTypeDescriptionRegistry registry) {
        projectType = new ProjectType(ESBProjectConstants.PROJECT_ID, ESBProjectConstants.PROJECT_NAME, ESBProjectConstants.CATEGORY);
        //register our project type
        registry.registerProjectType(this);
    }

    @Override
    public ProjectType getProjectType() {
        return projectType;
    }

    @Nonnull
    @Override
    public List<Attribute> getPredefinedAttributes() {
        return Arrays.asList(new Attribute(Constants.LANGUAGE, "java"));
    }

    @Override
    public Builders getBuilders() {
        return new Builders("maven");
    }

    @Override
    public Runners getRunners() {
        return null;
    }

    @Override
    public List<ProjectTemplateDescription> getTemplates() {
        return null;
    }

    @Override
    public Map<String, String> getIconRegistry() {
        return null;
    }
}
