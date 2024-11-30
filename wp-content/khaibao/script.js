import { getTruongs, getDotcuutros, postURL } from "../../common/common.js";
// ============== Show list nganh =================

const datalistTruong = document.getElementById("options_truong");
const datalistDotcuutro = document.getElementById("options_dotcuutro");

$(document).ready(function () {
  $.getJSON(getTruongs, function (data, textStatus, jqXHR) {
    $.each(data, function (indexInArray, valueOfElement) {
      const option = document.createElement("option");
      option.value = valueOfElement.matruong;
      option.textContent = valueOfElement.tentruong;
      datalistTruong.appendChild(option);
    });
  });

  $.getJSON(getDotcuutros, function (data, textStatus, jqXHR) {
    $.each(data, function (indexInArray, valueOfElement) {
      const option = document.createElement("option");
      option.value = valueOfElement.madotcuutro;
      option.textContent = valueOfElement.khauhieu;
      datalistDotcuutro.appendChild(option);
    });
  });

  //============= Ngày cứu trợ ===============
  const ngaycuutro = document.getElementById("ngaycuutro");

  ngaycuutro.addEventListener("input", () => {
    let month = parseInt(new Date().getUTCMonth()) + 1;
    let ngaynow =
      new Date().getFullYear() + "-" + month + "-" + new Date().getDate();
    let _ngaycuutro = ngaycuutro.value;

    console.log(ngaynow);
    console.log(_ngaycuutro);

    ngaynow = new Date(ngaynow);
    _ngaycuutro = new Date(_ngaycuutro);

    let diff = new Date(_ngaycuutro - ngaynow);
    let CHECK = diff / 1000;
    console.log(CHECK);
    let days = diff / 1000 / 60 / 60 / 24;

    console.log(days);

    if (days >= 0) {
      ngaycuutro.setCustomValidity("Ngày không hợp lệ.");
    }
  });


  $("#form_cuutro").submit(function (e) {
    e.preventDefault();
    const masv = $("#masv").val();
    const hoten = $("#hoten").val();
    const sdt = $("#sdt").val();
    const email = $("#email").val();
    const ngaycuutro = $("#ngaycuutro").val();
    const matruong = $("#truong").val();
    const madotcuutro = $("#dotcuutro").val();
    const dexuatcaithien = $("#dexuatcaithien").val();

    $.ajax({
      url: postURL,
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify({
        masv,
        hoten,
        sdt,
        email,
        chitietcuutroDTOS: [
          {
            matruong,
            madotcuutro,
            ngaycuutro,
            dexuatcaithien,
          },
        ],
      }),
      success: function (response) {
        console.log(response);
        alert("thành công!");
      },
      error: function (error) {
        alert("không thành công!");
      },
    });
  });
});
