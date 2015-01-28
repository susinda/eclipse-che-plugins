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

import com.codenvy.ide.api.mvp.View;
import com.google.inject.ImplementedBy;

/**
 * @author Evgen Vidolob
 */
@ImplementedBy(ESBConfigurationViewImpl.class)
public interface ESBConfigurationView extends View<ESBConfigurationView.ActionDelegate> {

    String getGroupId();

    void setGroupId(String groupId);

    String getArtifactId();

    void setArtifactId(String artifactId);

    String getVersion();

    void setVersion(String version);


    interface ActionDelegate {

        void onGroupIdChanged();

        void onArtifactIdChanged();

        void onVersionChanged();
    }

}
