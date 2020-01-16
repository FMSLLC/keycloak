/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.keycloak.forms.login.freemarker.model;

import java.util.Collections;
import java.util.List;

import org.keycloak.authentication.AuthenticationFlowContext;
import org.keycloak.authentication.AuthenticationSelectionOption;
import org.keycloak.forms.login.LoginFormsPages;

/**
 * @author <a href="mailto:mposolda@redhat.com">Marek Posolda</a>
 */
public class AuthenticationContextBean {

    private final AuthenticationFlowContext context;
    private final LoginFormsPages page;

    public AuthenticationContextBean(AuthenticationFlowContext context, LoginFormsPages page) {
        this.context = context;
        this.page = page;
    }

    public List<AuthenticationSelectionOption> getAuthenticationSelections() {
        return context==null ? Collections.emptyList() : context.getAuthenticationSelections();
    }

    public boolean showTryAnotherWayLink() {
        return getAuthenticationSelections().size() > 1 && page != LoginFormsPages.LOGIN_SELECT_AUTHENTICATOR;
    }
}
