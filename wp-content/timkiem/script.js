import { searchSinhvien } from "../../common/common.js";
$(document).ready(function () {
  $("#btn_search").click(function (e) {
    e.preventDefault();

    const value = $("#input_search").val();

    console.log(value);

    $("div.abody").html("");

    $.ajax({
      type: "POST",
      url: searchSinhvien,
      contentType: "application/json",
      data: JSON.stringify(value),
      success: function (response) {
        $.each(response, function (indexInArray, value) {
          console.log(value);

          let content = `
                      <div class="qh_c">
                            <div style="word-wrap: break-word;">${value.masv}</div>
                            <div style="word-wrap: break-word;">${value.hoten}</div>
                            <div style="word-wrap: break-word;">${value.tentruong}</div>
                            <div style="word-wrap: break-word;">${value.madotcuutro}</div>
                            <div style="word-wrap: break-word;">${value.khauhieu}</div>
                            <div style="word-wrap: break-word;">${value.ngaycuutro}</div>
                            <div style="word-wrap: break-word;">${value.dexuatcaithien}</div>
                            <div><button type="submit" style="color: red;">Xoá</button></div>

                      </div>

          `;

          $("div.abody").append(content);
        });
      },
      error: function (error) {
        alert("không thành công!");
        console.log(error);
      },
    });
  });
});
