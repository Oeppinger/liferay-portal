/**
 * Copyright (c) 2000-2007 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.liferay.portlet.messageboards.action;

import com.liferay.portal.model.Layout;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.Constants;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.messageboards.service.MBBanServiceUtil;
import com.liferay.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/**
 * <a href="BanUserAction.java.html"><b><i>View Source</i></b></a>
 *
 * @author  Michael Young
 *
 */
public class BanUserAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig config,
			ActionRequest req, ActionResponse res)
		throws Exception {
		
		String cmd = ParamUtil.getString(req, Constants.CMD);

		if (cmd.equals(Constants.BAN_USER)) {
			banUser(req);
		}
		else if (cmd.equals(Constants.UNBAN_USER)) {
			unbanUser(req);
		}

		sendRedirect(req, res);
	}
		
	protected void banUser(ActionRequest req) 
		throws Exception {
		
		Layout layout = (Layout)req.getAttribute(WebKeys.LAYOUT);
		String banUserId = ParamUtil.getString(req, "ban_user_id");
		
		MBBanServiceUtil.addBan(layout.getPlid(), banUserId);		
	}
		
	protected void unbanUser(ActionRequest req) 
		throws Exception {
	
		String banId = ParamUtil.getString(req, "ban_id");
		
		MBBanServiceUtil.deleteBan(banId);		
	}

}
