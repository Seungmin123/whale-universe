var PAGE_NUM = 0

var main = {
    init : function (){
        $('#searchBtn').on("click", function(){
            $('#datatables tbody tr').remove()
            getOtherOrderList(0, 10, $('#searchData').val())
        })

        $('#prevPage').on("click", function(){
            $('#datatables tbody tr').remove()
            if(PAGE_NUM - 1 > -1) PAGE_NUM = PAGE_NUM - 1
            getOtherOrderList(PAGE_NUM, 10, $('#searchData').val())
        })

        $('#nextPage').on("click", function(){
            $('#datatables tbody tr').remove()
            PAGE_NUM = PAGE_NUM + 1
            getOtherOrderList(PAGE_NUM, 10, $('#searchData').val())
        })

    }
}

function getMyInfo(){
    $.ajax({
        type: 'POST',
        url: '/api/v1/user/info',
        contentType:'application/json; charset=utf-8'
    }).done(function(obj){
        $('#myName').replaceWith(obj.name)
        $('#myNickName').replaceWith(obj.nickName)
        $('#myPassword').replaceWith(obj.password)
        $('#myEmail').replaceWith(obj.email)
        $('#myTell').replaceWith(obj.tell)
        $('#myGender').replaceWith  (obj.gender)
    }).fail(function(error){
        alert(JSON.stringify(error))
    })
}

function getOrderList(searchedId){
    $.ajax({
        type: 'POST',
        url: '/api/v1/order/list/'+searchedId,
        contentType:'application/json; charset=utf-8',
    }).done(function(obj){
        addOrderData('#datatablesSimple tbody', obj)
    }).fail(function(error){
        alert(JSON.stringify(error))
    })
}

function getOtherOrderList(pageNum, sizeNum, searchName){

    var name = 'undefined'
    if(searchName) name = searchName

    if(!pageNum) pageNum = PAGE_NUM
    if(!sizeNum) sizeNum = 10

    var data = {
        pageNumber: pageNum,
        pageSize: sizeNum
    }

    $.ajax({
        type: 'POST',
        url: '/api/v1/order/otherList/'+name,
        dataType: 'json',
        contentType:'application/json; charset=utf-8',
        data: JSON.stringify(data)
    }).done(function(obj){
        addOtherOrderData('#datatables tbody', obj)
    }).fail(function(error){
        alert(JSON.stringify(error))
    })
}

function addOrderData(divId, obj){
    let tbody = $(divId)

    obj.forEach(element => {
        let tr = $("<tr>")

        tr.append("<td>" + element.orderNum + "</td>" )
        tr.append("<td>" + element.itemName + "</td>" )
        tr.append("<td>" + element.createdDate + "</td>" )

        tbody.append(tr)
    })
}

function addOtherOrderData(divId, obj){
    let tbody = $(divId)

    obj.forEach(element => {
        let tr = $("<tr>")

        tr.append("<td>" + element.name + "</td>" )
        tr.append("<td>" + element.orderNum + "</td>" )
        tr.append("<td>" + element.itemName + "</td>" )
        tr.append("<td>" + element.createdDate + "</td>" )

        tbody.append(tr)
    })
}

main.init()