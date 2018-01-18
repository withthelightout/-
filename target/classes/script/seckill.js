//存放主要交互逻辑js代码
//js模块化
var seckill={
		//封装秒杀相关url
		URL : {
			
		},
		//验证手机号逻辑
		validatePhone:function(phone){
			if(phone&&phone.length==11&&!isNaN(phone)){
				return true;
			}else{
				return false;
			}
		},
		//详情页秒杀逻辑
		detail :{
			init : function(params){
				//手机验证和登录 计时交互
				//规划我们的交互流程
				//在cookie中查找手机号
				var killPhone=$.cookie('killPhone');
				var startTime=params['startTime'];
				var endTime = params['endTime'];
				var seckillId = params['seckillId'];
				//验证手机号
				if(!seckill.validatePhone(killPhone)){
					//绑定phone
					//控制输出
//					var killPhoneModal = $('#killPhoneModal');
					$('#killPhoneModal').modal({
						show:true,
						backdrop:'static',
						keyboard:false
					});
					$('#killPhoneBtn').click(function(){
						var inputPhone = $('KillPhoneKey').val();
						console.log("inputPhone="+inputPhone);//TODO
						if(seckill.validatePhone(inputPhone)){
							//电话写入cookie
							$.cookie('killPhone',inputPhone,{expires:7,path:'/seckill'});
							window.location.reload();
						}else{
							$('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误！</label>').show(300);
						}
					});
				}
				//已经登录
			}
		}
}