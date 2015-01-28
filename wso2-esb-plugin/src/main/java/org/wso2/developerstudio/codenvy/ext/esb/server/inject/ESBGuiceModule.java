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
package org.wso2.developerstudio.codenvy.ext.esb.server.inject;

import com.codenvy.api.project.server.ProjectGenerator;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import org.wso2.developerstudio.codenvy.ext.esb.server.genarator.ESBProjectGenerator;
import org.wso2.developerstudio.codenvy.ext.esb.server.project.type.ESBProjectTypeDescriptionExtension;
import org.wso2.developerstudio.codenvy.ext.esb.server.project.type.ESBProjectTypeExtension;
import com.codenvy.inject.DynaModule;

/**
 * @author Evgen Vidolob
 */
@DynaModule
public class ESBGuiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ESBProjectTypeExtension.class);
        bind(ESBProjectTypeDescriptionExtension.class);
        Multibinder.newSetBinder(binder(), ProjectGenerator.class).addBinding().to(ESBProjectGenerator.class);
    }
}
