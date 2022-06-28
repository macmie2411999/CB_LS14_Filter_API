jQuery(document).ready(function ($) {

    $('#btn-register').click(function (e) {
        e.preventDefault()

        var fullname = $('#fullname').val()
        var email = $('#email').val()
        var password = $('#password').val()

        $.ajax({
            url: 'http://localhost:8080/DemoFilter/api/register',
            type: 'get',
            data: {
                fullname: fullname,
                email: email,
                password: password
            }
        }).done(function (result) {
            if (result.success) {
                //Thanh cong
                $('#message').append('<h1>Thành công</h1>')
            } else {
                //That bai
                $('#message').append('<h1>Thất bại</h1>')
            }
        }).fail(function (error) {

        })

    })

})