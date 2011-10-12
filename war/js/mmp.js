//active track list
var track_list = []
//constructor
function track_cons(title,artist){
    if( artist != ""){
        //FIXME:
        //this.artist = artist
        this.title = artist+' '+title
    }
    else
        this.title = title


    this.offset = 0
}

function onYouTubePlayerReady(id){
    var ytplayer = document.getElementById(unescape(id));
    ytplayer.playVideo();
    ytplayer.addEventListener("onStateChange", "onytplayerStateChange");
}

function onytplayerStateChange(newState) {
    //next track
    if(newState == 0)
        nextTrack()
}

function play(track_li){
    //IE hack
    $('this').find('span.track-title').textShadow();

    //disactive prev track
    $('li.active').find('object').remove()
    $('li.active').removeClass('active')

    //activating next
    track_li.addClass('active')
    var video_id = track_li.find('a.track-url').attr('href')
    $('#YTplayer-template').clone().attr('id','YTplayer'+video_id)
            .css('display','block').appendTo(track_li)

    //embeding swf
    var params = { allowScriptAccess: "always" };
    var attrs = { id: "YTplayer"+video_id };
    swfobject.embedSWF("http://www.youtube.com/v/"+video_id+"?enablejsapi=1&playerapiid=YTplayer"+video_id,
                           "YTplayer"+video_id, "830", "696", "8", null, null, params, attrs);
}

function nextTrack()
{
    var track_li = $('li.active').next()

    //no next? then repeat
    if(track_li == null)
        track_li = $('#track_list li:first')

    //empty track list? So do nothing
    if(track_li == null)
        return

    play(track_li)
}


function getPlayList(){

    if($('#ololo').val() == '')
        return;

    //raw string from texarea
    var track_list_raw = $('#ololo').val().split('\n')
    //track objects
    var track_list_req=[]
    //serialized track list
    var JSON_req_obj={}
    //request type
    var req_type = 'multiple_titles'


    //detect input type
    var artist=""
    if(track_list_raw[1] == ""){
        artist = track_list_raw[0]

        //remove excess
        track_list_raw.shift()
        track_list_raw.shift()

        //setting request type
        //req_type = 'multiple_artists'
    }

    for (var key in track_list_raw)
         track_list_req.push(new track_cons(track_list_raw[key],artist))

    JSON_req_obj = JSON.stringify({
                                        "tracks":track_list_req
                                   })

    function loadTracks(data){
        //setting new tracks
        track_list = data.tracks

        for(k in track_list){
            track = track_list[k]
            insertTrackLi(track.title,track.duration,track.id)
        }

        //show tracks
        $('#track_list').slideDown()
        $('#loader').hide();

        //play first
        play($('#track_list li:first'))

        //disabled btn
        $('#theB').removeAttr('disabled')

        window.location.hash = "done";
    }

    //disabled btn
    $('#theB').attr('disabled','disabled')

    //hide tracks DOM elements
    $('#track_list').slideUp()
    $('#loader').show();
    $('#track_list').html('')

    $.ajax( {
        type : 'POST',
        url : '/mmp_gae',
        data : {'type':req_type,
                'json':JSON_req_obj},
        dataType : 'json',
        success : loadTracks
    });
}

function insertTrackLi(title,duration,video_id){
    var bk_ind = 6+Math.floor(Math.random()*9.4)
    $('<li class="track"></li>')
            .append('<span class="track-title">'+title+'</span>')
            .append('<span class="track-duration">'+duration+'</span>')
            .append('<a class="track-url" href="'+video_id+'"></a>')
            .append('<a class="rem-track" href="javascript:void(0)">X</a>')
            .append('<br/><br/>')
            .css('background-image','url("img/Patterns3-'+bk_ind+'.png")')
            .appendTo('#track_list')
}

$(function(){
    $('#ololo').watermark('Artist\n\nTrack title\nTrack title\n' +
                         '\nOR\n\nArtist - Track title\nArtist - Track title')

    //main button click
    $('#theB').click(function(){
        $('#ololo').blur(function(){
            $(this).animate({'height':'3em'},{duration:300})
        })
        getPlayList()
    });

    //remove track from playlist
    $('a.rem-track').live('click',function(){
        $(this).parent().remove();
        return false;
    })

    //
    $('li:not(.active)').live('click',function(t){
        play($(this))
    })
})

