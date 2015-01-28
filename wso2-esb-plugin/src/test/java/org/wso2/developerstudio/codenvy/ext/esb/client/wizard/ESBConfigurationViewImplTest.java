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

package org.wso2.developerstudio.codenvy.ext.esb.client.wizard;

import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwtmockito.GwtMockitoTestRunner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(GwtMockitoTestRunner.class)
public class ESBConfigurationViewImplTest {

    private static final String SOME_TEXT = "some text";

    @Mock
    private ESBConfigurationView.ActionDelegate delegate;
    @InjectMocks
    private ESBConfigurationViewImpl view;

    @Before
    public void setUp() throws Exception {
        view.setDelegate(delegate);
    }

    @Test
    public void groupIdContentShouldBeReturned() throws Exception {
        when(view.groupId.getText()).thenReturn(SOME_TEXT);

        assertThat(view.getGroupId(), is(SOME_TEXT));

        verify(view.groupId).getText();
    }

    @Test
    public void groupIdShouldBeChanged() throws Exception {
        view.setGroupId(SOME_TEXT);

        verify(view.groupId).setText(SOME_TEXT);
    }

    @Test
    public void userActionShouldBeDelegatedWhenUserChangedGroupId() throws Exception {
        view.onGroupIdChanged(mock(KeyUpEvent.class));

        verify(delegate).onGroupIdChanged();
    }

}