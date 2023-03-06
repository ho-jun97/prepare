let table;
$(document).ready(function () {
    table = $("#data_list").DataTable({
        searching: false,
        responsive: true,
        select: true,
        ordering: true,
        paging: true,
        lengthChange: false,
        info: true,
        ajax: {
            data: {

            },
            url: "/cars",
            type: "GET",
            contentType: "application/json",
            dataSrc: function(data){
                return data;
            }
        },
        columns: [
            {data: "id"},
            {data: "number"},
            {data: "username"},
            // {data: "location"}
        ],
        columnDefs: [
            {
                target: 0,
                render: function(data, type, row, meta){
                    // data : 값
                    // type : display
                    // row :  object
                    // meta : object
                    return '<a href="https://www.naver.com">'+data+'</a>';
                }
            }

        ],
    });

    $('#searchBtn').click(function(){
        let data = {
            target: $("#target").val()
        }
        $.ajax({
            url: "/cars",
            type: "GET",
            data: data,
            contentType: "application/json",
        })
    })
    $('#data_list').DataTable().destroy();
});

