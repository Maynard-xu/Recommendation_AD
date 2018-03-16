function Search(ev) {
    if (ev.keyCode === 13) {
        ev.preventDefault();
        var search = $('#main_search');
        var search_word = search.val();
        search.val('');
        get_search(search_word);
    }
}

function get_search(keyword) {
    $.ajax({
        type: 'POST',
        url: '/get_search',
        data: {
            keyword: keyword,
            PrePageNum: 2
        },
        success: function (data) {
            for (var i in data) {
                var ss = $.parseJSON(data[i]);
                for (var k in ss) {
                    addLink(k, ss[k]);
                }
            }
        }
    });
}

function addLink(name, link) {
    $('#content_list').append('<li><span onclick="click_span(this)" id=' + link + '>' + name + '</span></li>');
}

function click_span(obj) {
    var link = obj.id;
    console.log(link);
    $('#view_box').attr("src", link);
}