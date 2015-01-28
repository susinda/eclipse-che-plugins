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

import com.codenvy.api.project.server.AttributeDescription;
import com.codenvy.api.project.server.ProjectType;
import com.codenvy.api.project.server.ProjectTypeDescriptionExtension;
import com.codenvy.api.project.server.ProjectTypeDescriptionRegistry;
import com.codenvy.api.project.shared.Constants;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.wso2.developerstudio.codenvy.ext.esb.shared.ESBProjectConstants;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

/**
 * @author Evgen Vidolob
 */
@Singleton
public class ESBProjectTypeDescriptionExtension implements ProjectTypeDescriptionExtension {

    @Inject
    public ESBProjectTypeDescriptionExtension(ProjectTypeDescriptionRegistry registry) {
        registry.registerDescription(this);
    }

    @Nonnull
    @Override
    public List<ProjectType> getProjectTypes() {
        return Arrays.asList(new ProjectType(ESBProjectConstants.PROJECT_ID, ESBProjectConstants.PROJECT_NAME, ESBProjectConstants.CATEGORY));
    }

    @Nonnull
    @Override
    public List<AttributeDescription> getAttributeDescriptions() {
        return Arrays.asList(new AttributeDescription(Constants.LANGUAGE));
    }
}
