
function fun1(){
    
        var password=prompt("请输入你的管理员密码：");
        if (password=="0"){
        window.location.href="selectAllBlog2"
    } else { //false
        window.history.back(-1)
    }
}
