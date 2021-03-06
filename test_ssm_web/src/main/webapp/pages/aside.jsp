<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${pageContext.request.contextPath}/img/user2-160x160.jpg"
					class="img-circle" alt="User Image">
			</div>
			<div class="pull-left info">
				<p>
					<security:authentication property="principal.username"></security:authentication>
				</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>

		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">菜单</li>
			<li id="admin-index"><a
				href="${pageContext.request.contextPath}/pages/main.jsp"><i
					class="fa fa-dashboard"></i> <span>首页</span></a></li>
			<security:authorize access="hasAnyRole('ADMIN')">
			<li class="treeview"><a href="#"> <i class="fa fa-cogs"></i>
					<span>系统管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>


			</a>
				<ul class="treeview-menu">
					<security:authorize access="hasAnyRole('ADMIN')">
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/user/findAll.do"> <i
							class="fa fa-circle-o"></i> 用户管理
					</a></li>
					</security:authorize>
					<li id="system-setting"><a
						href="${pageContext.request.contextPath}/role/findAll.do"> <i
							class="fa fa-circle-o"></i> 角色管理
					</a></li>

<%--					<li id="system-setting"><a--%>
<%--						href="${pageContext.request.contextPath}/permission/findAll.do">--%>
<%--							<i class="fa fa-circle-o"></i> 资源权限管理--%>
<%--					</a></li>--%>
<%--					<li id="system-setting"><a--%>
<%--						href="${pageContext.request.contextPath}/sysLog/findAll.do?page=1&size=4"> <i--%>
<%--							class="fa fa-circle-o"></i> 访问日志--%>
<%--					</a></li>--%>
				</ul></li>
			</security:authorize>
			<li class="treeview"><a href="#"> <i class="fa fa-cube"></i>
					<span>基础数据</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span>
			</a>
				<ul class="treeview-menu">

<%--					<li id="system-setting"><a--%>
<%--						href="${pageContext.request.contextPath}/product/findAll.do">--%>
<%--							<i class="fa fa-circle-o"></i> 产品管理--%>
<%--					</a></li>--%>
<%--					<li id="system-setting"><a--%>
<%--						href="${pageContext.request.contextPath}/orders/findAll.do?page=1&size=4"> <i--%>
<%--							class="fa fa-circle-o"></i> 订单管理--%>
<%--					</a></li>--%>
	<security:authorize access="hasAnyRole('ADMIN')">
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/books/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 图书管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/borrow/borrowView.do"> <i
							class="fa fa-circle-o"></i> 借阅管理
					</a></li>
					<li id="system-setting"><a
							href="${pageContext.request.contextPath}/borrow/findAll.do?page=1&size=4"> <i
							class="fa fa-circle-o"></i> 借阅记录
					</a></li>
	</security:authorize>
	<security:authorize access="hasAnyRole('USER')">
		<li id="system-setting"><a
				href="${pageContext.request.contextPath}/books/findAll.do?page=1&size=4"> <i
				class="fa fa-circle-o"></i> 图书信息
		</a></li>
		<li id="system-setting"><a
				href="${pageContext.request.contextPath}/borrow/findAllByUser.do?page=1&size=4"> <i
				class="fa fa-circle-o"></i> 我的借阅记录
		</a></li>
	</security:authorize>
				</ul></li>

		</ul>
	</section>
	<!-- /.sidebar -->
</aside>