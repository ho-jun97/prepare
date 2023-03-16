let table;
$(document).ready(function () {
    let len;
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
                target: function() { return $("#target").val()}
            },
            url: "/cars",
            type: "GET",
            contentType: "application/json",
            dataSrc: function(data){
                len = $("#target").val().length
                if(len < 4 && len !== 0){
                    alert("차량 번호를 다시 입력하시오")
                }
                return data;
            }
        },
        columns: [
            {data: "id"},
            {data: "number"},
            {data: "username"},
            {data: "address"},
            {data: null},
        ],
        columnDefs: [
            {
                target: 4,
                render: function(data, type, row, meta){
                    return '<a href="car/update?id='+row.id+'" class="btn btn-outline-success">수정</a>'
                }
            },
            {target: 0, width: "100px"},
            {target: 1, width: "200px"},
            {target: 2, width: "100px"},
            {target: 3, width: "400px"},
            {target: 4, width: "50px"},
        ],
    });
    $("#data_list tbody").on('click', 'tr', function(){
        var data = table.row(this).data();
        panTo(data.lat, data.lng);
    })

    $('#searchBtn').click(function(){
        table.ajax.reload();
    });
});

