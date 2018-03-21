<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0056)http://photo.auto.sina.com.cn/chezhan/2010Beijing/match/ -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=GBK">

<title>优就业-JAVA1016班颜值评选</title>
<meta name="Keywords" content="优就业-JAVA1016班颜值评选">
<link type="text/css" rel="stylesheet" href="css/top50.css">
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript">
vote(0);
function vote(modelid)
{
	console.log("aaa");
	$.ajax({
		async:true,
		type:"POST",
		url:"getRedisSet.do",
		data:{modelid:modelid},
		dataType: "json",
		success:function(data){
		for(var key in data){
		console.log(data[key].name);
		}
		
		var str="";
			for(var key in data){
			console.log(data[key].poll);
			str+="<dd><div class='divimg'><img src='/0316day/img/"+data[key].picture+"'  width='140' height='213' alt='"+data[key].name+"'></div>"+
			"<ul><li><input type='button' onclick='vote("+data[key].id+")'><em>"+data[key].poll+"</em>票</li></ul>"+
			"<div class='picbg'></div><h2><a target='_blank' href='#'>"+data[key].name+"</a></h2></dd>"
			}
			$(".piclist2").html(str);
		}
	}
	);
}
</script>
</head>
<body>

<div class="w950">
	<div class="s_title">
		<h3><b>优就业-JAVA1016班颜值评选</b></h3>
	</div>
	<div class="s_block">
	<div class="ss">
		<dl class="piclist2">
			<!-- 	<dd>
			<div class="divimg"><img src="/0316day/img/feng.jpg"  width="140" height="213" alt="冯荣新"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;444&#39;)"><em>116605</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">冯荣新</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/hao.jpg"  width="140" height="213" alt="郝峰磊"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;179&#39;)"><em>101293</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">郝峰磊</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/baole.jpg"  width="140" height="213" alt="菅保乐"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;137&#39;)"><em>36726</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">菅保乐</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/liyan.jpg"  width="140" height="213" alt="李言"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;217&#39;)"><em>31075</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">李言</a></h2>
		</dd>
				<dd class="mr0">
			<div class="divimg"><img src="/0316day/img/chenxiao.jpg"  width="140" height="213" alt="刘晨潇"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;262&#39;)"><em>28984</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">刘晨潇</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/jiaming.jpg"  width="140" height="213" alt="刘佳明"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;134&#39;)"><em>25562</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">刘佳明</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/liujian.jpg"  width="140" height="213" alt="刘建"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;276&#39;)"><em>24963</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="">刘建</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/liu.jpg"  width="140" height="213" alt="刘文凯"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;49&#39;)"><em>6446</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">刘文凯</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/lu.jpg"  width="140" height="213" alt="路永国"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;273&#39;)"><em>1436</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">路永国</a></h2>
		</dd>
				<dd class="mr0">
			<div class="divimg"><img src="/0316day/img/wang.jpg"  width="140" height="213" alt="王之允"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;333&#39;)"><em>864</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">王之允</a></h2>
		</dd>
				
				<dd>
			<div class="divimg"><img src="/0316day/img/wei.jpg"  width="140" height="213" alt="魏竞"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;143&#39;)"><em>25562</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">魏竞</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/haijun.jpg"  width="140" height="213" alt="周海军"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;267&#39;)"><em>24963</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="">周海军</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/zhou.jpg"  width="140" height="213" alt="周康康"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;48&#39;)"><em>6446</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">周康康</a></h2>
		</dd>
				<dd>
			<div class="divimg"><img src="/0316day/img/sun.jpg"  width="140" height="213" alt="孙老师"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;273&#39;)"><em>1436</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">孙老师</a></h2>
		</dd>
				<dd class="mr0">
			<div class="divimg"><img src="/0316day/img/cai.jpg"  width="140" height="213" alt="蔡文炳"></div>
			<ul>
			<li><input type="button" onclick="vote(1,&#39;45&#39;)"><em>864</em>票</li>
			</ul>
			<div class="picbg"></div>
			<h2><a target="_blank" href="#">蔡文炳</a></h2>
		</dd> -->
		
				
				</dl>
		</div>
	</div>
</div>
</body></html>