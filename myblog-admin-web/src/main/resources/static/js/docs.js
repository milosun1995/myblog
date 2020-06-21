// namespace
window.semantic = {
  handler: {}
};

// ready event
semantic.ready = function() {
  // selector cache
  var
 
    $menu                = $('#toc'),
    $hideMenu            = $('#toc .hide.item'),
    $container           = $('.main.container'),
    $followMenu          = $container.find('.following.menu'),

  // event handlers
  handler = {
    activate: {
      previous: function() {
        var
          $menuItems  = $followMenu.children('.item'),
          $section    = $menuItems.filter('.active'),
          index       = $menuItems.index($section)
        ;
		
        if($section.prev().size() > 0) {
          $section
            .removeClass('active')
            .prev('.item')
            .addClass('active')
          ;
        }
      }
    }
  };

  $('.launch.button, .view-ui, .launch.item')
    .on('click', function(event) {
      $menu.sidebar('toggle');
    });
};

// attach ready event
$(document)
  .ready(semantic.ready)
;
