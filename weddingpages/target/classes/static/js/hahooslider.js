//   ---------------------------------------------------------------------------
//   Copyright (C) Hahoo Network Technology Co.,Ltd
//	URL:http://www.hahoo.cn or http://www.hahoo.com.cn
//   ---------------------------------------------------------------------------

(function($) {

    var $transition_time = 1000;
    var $time_between_slides = 4000;

    $.hahooSlider = {
        loadImg:function(bigpic, pic, lname, url){
            //$(bigpic).removeClass('loading').html('');
            //setTimeout(function(){$(bigpic).addClass('loading');}, 2000);
            $(bigpic).addClass('loading').html('');
            var img = new Image();
            var aid = $(bigpic).attr('id') + '_a_' + lname;
            $(img).load(function () {
                $(this).hide();
                $(bigpic).removeClass('loading').html('<a href="' + url + '" target="_blank" id="' + aid + '"></a>');
                $('#' + aid).append(this);
                $(this).fadeIn();
            }).error(function () {
                // notify the user that the image could not be loaded
            }).attr('src', pic);
        }
    }

    $.fn.hahooSlider=function(options){
        var settings = {
            bigpic:"#bigpic",
            lname:"slider"
        };
        if(options){
            $.extend(settings, options);
        }

        var $i = 0;
        var $len = $(this).find('a').length;
        //$('#slider_0').trigger("click");
        $.hahooSlider.loadImg(settings.bigpic, $('#'+ settings.lname +'_0').data('bimg'), settings.lname, $('#'+ settings.lname +'_0').attr('href'));

        var interval = setInterval(
            function(){
                if($i + 1 == $len) $i = -1;
                $i++;
                //$('#slider_' + $i).trigger("click");
                $.hahooSlider.loadImg(settings.bigpic, $('#'+ settings.lname + "_" + $i).data('bimg'), settings.lname, $('#'+ settings.lname + "_" + $i).attr('href'));
            }
            , $transition_time +  $time_between_slides
        );

        $('ul li a',this).mouseover(function() {
            clearInterval(interval);
            var pic = $(this).data('bimg');
            var url = $(this).attr('href');
            $.hahooSlider.loadImg(settings.bigpic, pic, settings.lname, url);

            return false;
        });

    };

})(jQuery);