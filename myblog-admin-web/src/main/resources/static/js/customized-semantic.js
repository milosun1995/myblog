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
        
        
        // set the value of this checkbox, batch delete.
     	 var checkedId="";
	     $('input[name=ids]').each(function() {
	    	if(this.checked == true){
	    		checkedId+=this.value+",";
	    	}
	     });
	     
	     $('#btnBatchDel').attr('data-ids',checkedId);
	     console.log(checkedId);
        
      }
    });
    
	
    //批量删除模态框
	$('#btnBatchDel').click(function() {
		var url = $(this).data("url");
		var ids = $(this).data("ids");
		 console.log($(this).data("url"));
		 $('.ui.tiny.test.modal').modal({
		      closable  : false,
		      onDeny    : function(){
		        //window.alert('Wait not yet!');
		      },
		      onApprove : function() {
		        //window.alert('Approved!');
		    	  window.location.replace(url+ids);
		      }
		    }).modal('show');
	 });
	
	
    //单个删除模态框
	$('.btnDel').click(function() {
		var url = $(this).data("url");
		var ids = $(this).data("id")+",";
		 $('.ui.tiny.test.modal').modal({
		      closable  : false,
		      onDeny    : function(){
		        //window.alert('Wait not yet!');
		      },
		      onApprove : function() {
		        //window.alert('Approved!');
		    	 window.location.replace(url+ids);
		      }
		    }).modal('show');
	 });
	
	//错误提示模态框
	$('.message .close')
	  .on('click', function() {
	    $(this).closest('.message').transition('fade');
	  })
	;
    
})(jQuery); 