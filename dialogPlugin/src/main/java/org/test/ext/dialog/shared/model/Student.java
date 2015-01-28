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
package org.test.ext.dialog.shared.model;

/**
 * Created by susinda on 1/26/15.
 */
public class Student {

    String name;
    int age;
    boolean isGraduate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGraduate() {
        return isGraduate;
    }

    public void setGraduate(boolean isGraduate) {
        this.isGraduate = isGraduate;
    }

}
