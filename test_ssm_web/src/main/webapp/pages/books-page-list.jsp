<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!DOCTYPE html>
<html>

<head>
<!-- 页面meta -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">




<title>数据 - AdminLTE2定制版</title>
<meta name="description" content="AdminLTE2定制版">
<meta name="keywords" content="AdminLTE2定制版">




<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.6 -->
<!-- Font Awesome -->
<!-- Ionicons -->
<!-- iCheck -->
<!-- Morris chart -->
<!-- jvectormap -->
<!-- Date Picker -->
<!-- Daterange picker -->
<!-- Bootstrap time Picker -->
<!--<link rel="stylesheet" href="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.css">-->
<!-- bootstrap wysihtml5 - text editor -->
<!--数据表格-->
<!-- 表格树 -->
<!-- select2 -->
<!-- Bootstrap Color Picker -->
<!-- bootstrap wysihtml5 - text editor -->
<!--bootstrap-markdown-->
<!-- Theme style -->
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<!-- Ion Slider -->
<!-- ion slider Nice -->
<!-- bootstrap slider -->
<!-- bootstrap-datetimepicker -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->








<!-- jQuery 2.2.3 -->
<!-- jQuery UI 1.11.4 -->
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<!-- Bootstrap 3.3.6 -->
<!-- Morris.js charts -->
<!-- Sparkline -->
<!-- jvectormap -->
<!-- jQuery Knob Chart -->
<!-- daterangepicker -->
<!-- datepicker -->
<!-- Bootstrap WYSIHTML5 -->
<!-- Slimscroll -->
<!-- FastClick -->
<!-- iCheck -->
<!-- AdminLTE App -->
<!-- 表格树 -->
<!-- select2 -->
<!-- bootstrap color picker -->
<!-- bootstrap time picker -->
<!--<script src="${pageContext.request.contextPath}/${pageContext.request.contextPath}/${pageContext.request.contextPath}/plugins/timepicker/bootstrap-timepicker.min.js"></script>-->
<!-- Bootstrap WYSIHTML5 -->
<!--bootstrap-markdown-->
<!-- CK Editor -->
<!-- InputMask -->
<!-- DataTables -->
<!-- ChartJS 1.0.1 -->
<!-- FLOT CHARTS -->
<!-- FLOT RESIZE PLUGIN - allows the chart to redraw when the window is resized -->
<!-- FLOT PIE PLUGIN - also used to draw donut charts -->
<!-- FLOT CATEGORIES PLUGIN - Used to draw bar charts -->
<!-- jQuery Knob -->
<!-- Sparkline -->
<!-- Morris.js charts -->
<!-- Ion Slider -->
<!-- Bootstrap slider -->
<!-- bootstrap-datetimepicker -->
<!-- 页面meta /-->

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/morris/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/select2/select2.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
<%--<link rel="stylesheet"--%>
<%--		  href="${pageContext.request.contextPath}/plugins/bootstrap-fileinput/css/fileinput.css">--%>
<%--<link rel="stylesheet"--%>
<%--		  href="${pageContext.request.contextPath}/plugins/bootstrap-fileinput/css/fileinput-rtl.css">--%>
</head>

<body class="hold-transition skin-purple sidebar-mini">

	<div class="wrapper">

		<!-- 页面头部 -->
		<jsp:include page="header.jsp"></jsp:include>
		<!-- 页面头部 /-->
		<!-- 导航侧栏 -->
		<jsp:include page="aside.jsp"></jsp:include>
		<!-- 导航侧栏 /-->

		<!-- 内容区域 -->
		<!-- @@master = admin-layout.html-->
		<!-- @@block = content -->

		<div class="content-wrapper">

			<!-- 内容头部 -->
			<section class="content-header">
				<h1>
					数据管理 <small>图书列表</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="#">数据管理</a></li>
					<li class="active">图书列表</li>
				</ol>
			</section>
			<!-- 内容头部 /-->

			<!-- 正文区域 -->
			<section class="content">

				<!-- .box-body -->
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">图书列表</h3>
					</div>

					<div class="box-body">

						<!-- 数据表格 -->
						<div class="table-box">

							<!--工具栏-->
							<div class="pull-left">
								<div class="form-group form-inline">
									<div class="btn-group">
										<security:authorize access="hasAnyRole('ADMIN')">
										<button type="button" class="btn btn-default" title="新建"
											onclick="location.href='${pageContext.request.contextPath}/pages/books-add.jsp'">
											<i class="glyphicon glyphicon-plus"></i> 新建
										</button>
<%--										<button type="button" class="btn btn-default" title="删除" onclick="del()">--%>
<%--&lt;%&ndash;												onclick="location.href='${pageContext.request.contextPath}/books/delete.do?id=${books.id}'"&ndash;%&gt;--%>
<%--											<i class="fa fa-trash-o"></i> 删除--%>
<%--										</button>--%>
										<button type="button" class="btn btn-default"  onclick="refresh()" title="刷新">
											<i class="fa fa-refresh"></i> 刷新
										</button>
										<button type="button" class="btn btn-default"  onclick="downloadTemplate()" title="下载模板">
											<i class="glyphicon glyphicon-download"></i> 下载模板
										</button>
                                        <button type="button" class="btn btn-default" data-action="post" id="import" title="上传文件">
                                            <i class="glyphicon glyphicon-upload"></i> 上传文件
                                        </button>
										</security:authorize>

<%--										<form method="post" action="${pageContext.request.contextPath}/books/upload.do" enctype="multipart/form-data">--%>
<%--												<input type="file" name="excelFile" />--%>
<%--												<input type="submit">--%>
<%--										</form>--%>
<%--										<button type="button" class="btn btn-default" title="屏蔽">--%>
<%--											<i class="fa fa-ban"></i> 屏蔽--%>
<%--										</button>--%>
<%--										<button type="button" class="btn btn-default" title="刷新">--%>
<%--											<i class="fa fa-refresh"></i> 刷新--%>
<%--										</button>--%>
									</div>

								</div>

								<div>
									<security:authorize access="hasAnyRole('ADMIN')">
									操作说明：请点击"下载模板"按钮获取模板excel文件，在模板文件中录入设置数据后点击"上传文件"按钮上传模板文件。
									</security:authorize>
								</div>

							</div>
							<div class="box-tools pull-right">
								<div class="has-feedback">
									<input type="text" class="form-control input-sm"
										   placeholder="搜索"> <span
										class="glyphicon glyphicon-search form-control-feedback"></span>
								</div>
							</div>
<%--							<div class="box-tools pull-right">--%>
<%--								<div class="box-tools pull-left">--%>
<%--									<select class="form-control select2" >--%>
<%--									<option>图书名称</option>--%>
<%--									<option>作者</option>--%>
<%--									<option>出版社</option>--%>
<%--									</select>--%>

<%--								</div>--%>
<%--								<div class="box-tools pull-right">--%>
<%--									<span class="glyphicon glyphicon-search" ></span>--%>
<%--								</div>--%>
<%--								<div class="box-tools pull-right">--%>
<%--									<input type="text"  class="form-control" placeholder="搜索" >--%>
<%--								</div>--%>


<%--							</div>--%>
							<!--工具栏/-->

							<!--数据列表-->
							<table id="dataList"
								class="table table-bordered table-striped table-hover dataTable">
								<thead>
									<tr>
										<th class="" style="padding-right: 0px;"><input
											id="selall" type="checkbox" class="icheckbox_square-blue">
										</th>
										<th class="sorting_asc">ID</th>
										<th class="sorting_desc">图书名称</th>
										<th class="sorting_asc sorting_asc_disabled">作者</th>
										<th class="sorting_desc sorting_desc_disabled">出版社</th>
										<th class="sorting">库存数量</th>
										<th class="text-center sorting">价格</th>
										<security:authorize access="hasAnyRole('ADMIN')">
										<th class="text-center">操作</th>
										</security:authorize>
									</tr>
								</thead>
								<tbody>


									<c:forEach items="${pageInfo.list}" var="books">

										<tr>
											<td><input name="ids" type="checkbox"></td>
											<td>${books.id }</td>
											<td>${books.name }</td>
											<td>${books.author }</td>
											<td>${books.press }</td>
											<td>${books.reserve_num }</td>
											<td class="text-center">${books.price }</td>
											<security:authorize access="hasAnyRole('ADMIN')">
											<td class="text-center">
												<button type="button" class="btn btn-primary btn-xs " onclick="location.href='${pageContext.request.contextPath}/books/findById.do?id=${books.id}'">详情</button>
												<button type="button" class="btn btn-info btn-xs  " onclick="location.href='${pageContext.request.contextPath}/books/updateById.do?id=${books.id}'">编辑</button>
												<a href="${pageContext.request.contextPath}/books/delete.do?id=${books.id}" onclick="return confirm('确认删除吗？')" class="btn btn-danger btn-xs ">删除</a>
<%--												<button type="button" class="btn btn-danger btn-xs " onclick="location.href='${pageContext.request.contextPath}/books/delete.do?id=${books.id}'">删除1</button>--%>
											</td>
											</security:authorize>
										</tr>
									</c:forEach>
								</tbody>
								<!--
                            <tfoot>
                            <tr>
                            <th>Rendering engine</th>
                            <th>Browser</th>
                            <th>Platform(s)</th>
                            <th>Engine version</th>
                            <th>CSS grade</th>
                            </tr>
                            </tfoot>-->
							</table>
							<!--数据列表/-->

							<!--工具栏-->
<%--							<div class="pull-left">--%>
<%--								<div class="form-group form-inline">--%>
<%--									<div class="btn-group">--%>
<%--										<button type="button" class="btn btn-default" title="新建">--%>
<%--											<i class="fa fa-file-o"></i> 新建--%>
<%--										</button>--%>
<%--										<button type="button" class="btn btn-default" title="删除">--%>
<%--											<i class="fa fa-trash-o"></i> 删除--%>
<%--										</button>--%>
<%--										<button type="button" class="btn btn-default" title="开启">--%>
<%--											<i class="fa fa-check"></i> 开启--%>
<%--										</button>--%>
<%--										<button type="button" class="btn btn-default" title="屏蔽">--%>
<%--											<i class="fa fa-ban"></i> 屏蔽--%>
<%--										</button>--%>
<%--										<button type="button" class="btn btn-default" title="刷新">--%>
<%--											<i class="fa fa-refresh"></i> 刷新--%>
<%--										</button>--%>
<%--									</div>--%>
<%--								</div>--%>
<%--							</div>--%>
<%--							<div class="box-tools pull-right">--%>
<%--								<div class="has-feedback">--%>
<%--									<input type="text" class="form-control input-sm"--%>
<%--										placeholder="搜索"> <span--%>
<%--										class="glyphicon glyphicon-search form-control-feedback"></span>--%>
<%--								</div>--%>
<%--							</div>--%>
							<!--工具栏/-->

						</div>
						<!-- 数据表格 /-->


					</div>
					<!-- /.box-body -->

					<!-- .box-footer-->
                <div class="box-footer">
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            总共${pageInfo.pages} 页，共${pageInfo.total} 条数据。 每页
                            <select class="form-control"  id="changePageSize" onchange="changePageSize()">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select> 条
                        </div>
                    </div>

                    <div class="box-tools pull-right">
                        <ul class="pagination">
                            <li>
                                <a href="${pageContext.request.contextPath}/books/findAll.do?page=1&size=${pageInfo.pageSize}" aria-label="Previous">首页</a>
                            </li>
                            <li><a href="${pageContext.request.contextPath}/books/findAll.do?page=${pageInfo.pageNum-1}&size=${pageInfo.pageSize}">上一页</a></li>

<%--							<c:forEach begin="1" end="${pageInfo.pages}" var="pageNum" >--%>
<%--							<-- 遍历导航页 -->--%>
<%--							<li><a href="<%=basePath%>user/ShowMedia?pn=1" rel="external nofollow" >首页</a></li>--%>
							<c:if test="${pageInfo.hasPreviousPage }">
								<li>
									<a href="${pageContext.request.contextPath}/books/findAll.do?page=${pageInfo.pageNum-1}" rel="external nofollow" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									</a>
								</li>
							</c:if>

							<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
								<c:if test="${page_Num == pageInfo.pageNum }">
									<li class="active"><a href="${pageContext.request.contextPath}/books/findAll.do?page=${ page_Num}&size=${pageInfo.pageSize}" rel="external nofollow" >${ page_Num}</a></li>
								</c:if>
								<c:if test="${page_Num != pageInfo.pageNum }">
									<li><a href="${pageContext.request.contextPath}/books/findAll.do?page=${ page_Num}" rel="external nofollow" >${ page_Num}</a></li>
								</c:if>
							</c:forEach>
							<c:if test="${pageInfo.hasNextPage }">
								<li>
									<a href="${pageContext.request.contextPath}/books/findAll.do?page=${pageInfo.pageNum+1}" rel="external nofollow" aria-label="Next">
										<span aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</c:if>

<%--							<li><a href="${pageContext.request.contextPath}/books/findAll.do?page=${pageNum}&size=${pageInfo.pageSize}">${pageNum}</a></li>--%>
<%--							<li><a href="${pageContext.request.contextPath}/books/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">${pageInfo.pageNum+1}</a></li>--%>
<%--							<li><a href="${pageContext.request.contextPath}/books/findAll.do?page=${pageInfo.pageNum+2}&size=${pageInfo.pageSize}">${pageInfo.pageNum+2}</a></li>--%>
<%--							</c:forEach>--%>

                            <li><a href="${pageContext.request.contextPath}/books/findAll.do?page=${pageInfo.pageNum+1}&size=${pageInfo.pageSize}">下一页</a></li>
                            <li>
                                <a href="${pageContext.request.contextPath}/books/findAll.do?page=${pageInfo.pages}&size=${pageInfo.pageSize}" aria-label="Next">尾页</a>
                            </li>
                        </ul>
                    </div>

                </div>
                <!-- /.box-footer-->



				</div>

			</section>
			<!-- 正文区域 /-->

		</div>
		<!-- @@close -->
		<!-- 内容区域 /-->

		<!-- 底部导航 -->
		<footer class="main-footer">
			<div class="pull-right hidden-xs">
				<b>Version</b> 1.0.8
			</div>
			<strong>Copyright &copy; 2014-2017 <a
				href="http://www.baidu.com">研究院研发部</a>.
			</strong> All rights reserved.
		</footer>
		<!-- 底部导航 /-->

	</div>


	<script
		src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
	<script
		src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>

    <script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery.ocupload.js"></script>
    <script
        src="${pageContext.request.contextPath}/plugins/jQuery/jquery.ocupload-min.js"></script>

	<script>

        $("#import").upload({
                     name : 'excelFile',     // 文件名，要与ation中的参数名一致
                     action : '${pageContext.request.contextPath}/books/upload.do',   // action路径
                    enctype : 'multipart/form-data',            // 设置编码格式，默认multipart/form-data
                    autoSubmit : true,                              // 选中文件提交表单
                     onComplete : function(flag) {             // 请求完成后的回调函数
                         if (flag == '0') {
							 // $("#myModal").modal(alert("q"));
                             //     alert("excel数据导入成功！");
                             } else {
							 alert("excel内容格式错误,数据导入失败！");
                             }
                     },
				onSelect: function() {//当用户选择了一个文件后触发事件
				//当选择了文件后，关闭自动提交
				this.autoSubmit=false;
				//校验上传的文件名是否满足后缀为.xls或.xlsx
				var regex =/^.*\.(?:xls|xlsx)$/i;
				//this.filename()返回当前选择的文件名称 (ps：我使用这个方法没好使，自己写了一个获取文件的名的方法) $("[name = '"+this.name()+"']").val())
				//alert(this.filename());
				if(regex.test($("[name = '"+this.name()+"']").val())){
					//通过校验
					this.submit();
					alert("excel数据导入成功！");
				}else{
					//未通过
					alert("文件格式不正确，必须以.xls或.xlsx结尾");
					// $("#myModal3").modal(); //错误提示框，文件格式不正确，必须以.xls或.xlsx结尾
					}
				}
             	});

		function downloadTemplate(){
			window.location.href="${pageContext.request.contextPath}/template/books_template.xlsx";
		}

		function refresh(){
			window.location.reload();
		}

		function changePageSize() {
			//获取下拉框的值
			var pageSize = $("#changePageSize").val();

			//向服务器发送请求，改变没页显示条数
			location.href = "${pageContext.request.contextPath}/books/findAll.do?page=1&size="
					+ pageSize;
		}
		$(document).ready(function() {
			// 选择框
			$(".select2").select2();

			// WYSIHTML5编辑器
			$(".textarea").wysihtml5({
				locale : 'zh-CN'
			});
		});

		// 设置激活菜单
		function setSidebarActive(tagUri) {
			var liObj = $("#" + tagUri);
			if (liObj.length > 0) {
				liObj.parent().parent().addClass("active");
				liObj.addClass("active");
			}
		}

		$(document).ready(function() {

			// 激活导航位置
			setSidebarActive("admin-datalist");

			// 列表按钮
			$("#dataList td input[type='checkbox']").iCheck({
				checkboxClass : 'icheckbox_square-blue',
				increaseArea : '20%'
			});
			// 全选操作
			$("#selall").click(function() {
				var clicks = $(this).is(':checked');
				if (!clicks) {
					$("#dataList td input[type='checkbox']").iCheck("uncheck");
				} else {
					$("#dataList td input[type='checkbox']").iCheck("check");
				}
				$(this).data("clicks", !clicks);
			});
		});
	</script>
</body>

</html>