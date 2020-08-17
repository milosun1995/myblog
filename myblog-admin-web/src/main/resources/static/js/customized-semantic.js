(function ($) {
	//下拉框
	$('.dropdown').dropdown({
		// you can use any ui transition
		transition: 'drop',
		message: {
		    addResult     : 'Add <b>{term}</b>',
		    count         : '{count} selected',
		    maxSelections : 'Max {maxCount} selections',
		    noResults     : '<a class="ui blue label"  onclick="tagsInput(\'{term}\')">Add</a>',
		    serverError   : 'There was an error contacting the server'
		  },
		onAdd: function(e, t, n) {
		  },
		onRemove: function(e, t, n) {
		},
		onNoResults: function(e) {
		    return ! 0
		},
	});
	
	//博客发布页面
    $('#publish-btn').click(function () {
        $('#blog-form').submit();
      });

    //semantic js click checkbox
//    $('.ui.checkbox').checkbox();
	
    
    
//    $('.master.checkbox').checkbox({
//      // check all children
//      onChecked: function() {
//        var $childCheckbox  = $('tr').siblings().find('.checkbox');
//        console.log($childCheckbox);
//        $childCheckbox.checkbox('check');
//      },
//      // uncheck all children
//      onUnchecked: function() {
//        var $childCheckbox  = $('tr').siblings().find('.checkbox');
//        $childCheckbox.checkbox('uncheck');
//      }
//    });
    $('.master.checkbox').checkbox({
        // check all children
        onChecked: function() {
          var $childCheckbox  = $(this).closest("thead").siblings('tbody').find('.checkbox');
          $childCheckbox.checkbox('check');
        },
        // uncheck all children
        onUnchecked: function() {
          var $childCheckbox  = $(this).closest("thead").siblings('tbody').find('.checkbox');
          $childCheckbox.checkbox('uncheck');
        }
      });
    
    $('.child.checkbox').checkbox({
      // Fire on load to set parent value
      fireOnInit : true,
      // Change parent state on each child checkbox change
      onChange   : function() {
        var
          $tbodyGroup      = $(this).closest('tbody'),
          $parentCheckbox = $tbodyGroup.siblings('thead').find('.checkbox'),
          $checkbox       = $tbodyGroup.find('.checkbox'),
          allChecked      = true,
          allUnchecked    = true
        ;

        // check to see if all other siblings are checked or unchecked
        $checkbox.each(function() {
          if($(this).checkbox('is checked')) {
            allUnchecked = false;
          }
          else {
            allChecked = false;
          }
        });

        // set parent checkbox state, but dont trigger its onChange callback
        if(allChecked) {
          $parentCheckbox.checkbox('set checked');
        }
        else if(allUnchecked) {
          $parentCheckbox.checkbox('set unchecked');
        }
        else {
          $parentCheckbox.checkbox('set indeterminate');
        }
      }
    });
    
    
})(jQuery); 