<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
       
        <div class="result-wrap">
            <form action="/MonkeyShop/manage/admin_douserdelete" name="myform" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/MonkeyShop/manage/admin_tocateadd"><i class="icon-font"></i>新增分类</a>
                       
                       <!--   <a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>-->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="40%">
                        <tr>
                          
                            
                            <th>ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                          
                        </tr>
                        
                        <c:forEach var="c" items="${categorylist}">
                       	<c:if test="${c.CATE_PARENT_ID==0}">
                        <tr>
                        
                        	<td>${c.CATE_ID}</td>
                        	<td>|-${c.CATE_NAME}</td>

                            <td>
                                <a class="link-update" href="admin_tocateupdate?id=${c.CATE_ID }">修改</a>&nbsp;&nbsp;&nbsp;<a class="link-del" href="">删除</a> 
                            </td>
                        </tr>
                         <c:forEach var="zc" items="${categorylist}">
                        <c:if test="${zc.CATE_PARENT_ID==c.CATE_ID}"> 
                        <tr>
                        	<td>${zc.CATE_ID}</td>
                        	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${zc.CATE_NAME}</td>

                            <td>
                                <a class="link-update" href="admin_tocateupdate?id=${c.CATE_ID }">修改</a>&nbsp;&nbsp;&nbsp;<a class="link-del" href="">删除</a> 
                            </td>
                             </tr>
                        </c:if> 
                        </c:forEach>
                      </c:if>
                      </c:forEach>
                      
                      <script>
                      	function Delete(mess,url){
                      		if(confirm(mess)){
                      			location.href=url;
                      		}
                      	}
                      	
                      
                      </script>
                    </table>
                
                </div>
            </form>
        </div>
    </div>
    <!--/main-->

</body>
</html>