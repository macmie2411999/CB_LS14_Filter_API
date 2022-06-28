jQuery(document).ready(function ($) {
    /*
    * Đọc file document (các files .jsp), khi các files này đã được load trên màn hình
    * thì Jquery mới kích hoạt code trong nó
    *
    * Do đó cần đặt jquery.min.js ở cuối trong các files giao diện .jsp
    * */

    $('#btn-register').click(function (e) {
        /*
        * Đặt sự kiện cho button
        * #: id - .: class
        * */

        e.preventDefault()
        /* function(e){e.preventDefault(): do Button nằm trong thẻ form, nên mặc định
        * sau khi nhấn Button thì sẽ chuyền sang POST/GET, lệnh này chặn việc submit form
        * */

        // mapping
        var fullname = $('#fullname').val()
        var email = $('#email').val()
        var password = $('#password').val()

        $.ajax({
            // Khi click thì chuyển sang url đích
            url: 'http://localhost:8080/DemoFilter/api/register',
            type: 'get',
            data: {
                // Truyền tham số vào link api (url)
                fullname: fullname,
                email: email,
                password: password
            }
        }).done(function (result) {
            // Thành công
            if (result.success) {
                $('#message').append('<h1>Thành công</h1>')
            } else {
                $('#message').append('<h1>Thất bại</h1>')
            }
        }).fail(function (error) {
            // Lỗi
        })
    })
})



