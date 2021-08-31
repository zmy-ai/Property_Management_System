package com.system.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

public class FileUtil {
    /**
     * 设置excel文件响应（解决火狐中文名问题）
     * @param request 请求对象
     * @param response 响应对象
     * @param filename 文件名
     * @throws Exception
     */
    public static void setResponse(HttpServletRequest request, HttpServletResponse response, String filename) throws Exception {
        String userAgent = request.getHeader("User-Agent");
        if (userAgent.toLowerCase().contains("firefox")) {
            filename = new String(filename.getBytes("UTF-8"), "ISO-8859-1");
        } else {
            filename = URLEncoder.encode(filename, "UTF-8");
        }
        response.setContentType(request.getServletContext().getMimeType(filename));
        response.setHeader("Content-disposition", String.format("attachment; filename=\"%s\"", filename));
    }
}
