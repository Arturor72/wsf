/*
 * Copyright 2005,2006 WSO2, Inc. http://www.wso2.org
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
 */
package org.wso2.wsf.idea.ws;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.Presentation;
import com.intellij.openapi.actionSystem.ActionPlaces;

import javax.swing.*;

import org.wso2.wsf.idea.ws.util.WSASClassLoadingUtil;
import org.wso2.wsf.idea.ws.util.PopupMessageUtil;
import org.wso2.wsf.idea.ws.bean.WSASConfigurationBean;
import org.wso2.wsf.idea.ws.constant.WSASMessageConstant;
import org.wso2.wsf.idea.ws.constant.WSASConfigurationConstant;

public class WSASStartAction extends AnAction {
    private ImageIcon myIcon;

    public void actionPerformed(AnActionEvent e) {
        if(WSASConfigurationBean.getWsasInstallationPath().equals( null)){
            PopupMessageUtil.popupWarningMessageBox(WSASMessageConstant.WARNING_WSAS_PATH_NOT_SET);
        }else if(WSASConfigurationBean.getWsasInstallationPath().equals(WSASConfigurationConstant.WSAS_DEFAULT_PATH) ){
            PopupMessageUtil.popupWarningMessageBox(WSASMessageConstant.WARNING_WSAS_PATH_NOT_SET);
        }
        WSASClassLoadingUtil.init(WSASConfigurationBean.getWsasInstallationPath());
        WSASClassLoadingUtil.loadClassFromAntClassLoader(WSASConfigurationConstant.WSAS_MAIN_CLASS);

    }

    public void update(AnActionEvent event) {
        super.update(event);
        Presentation presentation = event.getPresentation();
        if (ActionPlaces.MAIN_TOOLBAR.equals(event.getPlace())) {
            if (myIcon == null) {
                java.net.URL resource = WSASStartAction.class.getResource("/icons/start.gif");
                myIcon = new ImageIcon(resource);
            }
            presentation.setIcon(myIcon);
        }
    }

}
