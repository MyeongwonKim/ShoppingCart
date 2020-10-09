$(function() {

    $("a.confirmDeletion").click(function() {
        console.log("confirmDeletion");
        if (!confirm("Confirm deletion")) return false;
    });

});