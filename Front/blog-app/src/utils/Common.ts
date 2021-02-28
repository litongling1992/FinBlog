export default class Common{
    public static before_time(dateTimeStamp:number):string{
        var minute = 1000 * 60; //把分，时，天，周，半个月，一个月用毫秒表示
    var hour = minute * 60;
    var day = hour * 24;
    var week = day * 7;
    var halfamonth = day * 15;
    var month = day * 30;
    var year = day * 365;
    var now = new Date().getTime(); //获取当前时间毫秒
    // console.log(now);
    var diffValue = now - dateTimeStamp; //时间差

    if (diffValue < 0) {
      return "";
    }
    var minC:number = diffValue / minute; //计算时间差的分，时，天，周，月
    var hourC:number = diffValue / hour;
    var dayC:number = diffValue / day;
    var weekC:number = diffValue / week;
    var monthC:number = diffValue / month;
    var yearC:number = diffValue / year;
    var result;
    if (yearC >= 1) {
      result = " " + yearC + " years  ago";
    } else if (monthC >= 1 && monthC <= 12) {
      result = " " + monthC + " months ago";
    } else if (weekC >= 1 && weekC <= 4) {
      result = " " + weekC + " weeks ago";
    } else if (dayC >= 1 && dayC <= 7) {
      result = " " + dayC + " days ago";
    } else if (hourC >= 1 && hourC <= 24) {
      result = " " + hourC + " hours ago";
    } else if (minC >= 1 && minC <= 60) {
      result = " " + minC + " minutes ago";
    } else if (diffValue >= 0 && diffValue <= minute) {
      result = "Just Now";
    } else {
      var datetime = new Date();
      datetime.setTime(dateTimeStamp);
      var Nyear = datetime.getFullYear();
      var Nmonth =
        datetime.getMonth() + 1 < 10
          ? "0" + (datetime.getMonth() + 1)
          : datetime.getMonth() + 1;
      var Ndate =
        datetime.getDate() < 10
          ? "0" + datetime.getDate()
          : datetime.getDate();
      var Nhour =
        datetime.getHours() < 10
          ? "0" + datetime.getHours()
          : datetime.getHours();
      var Nminute =
        datetime.getMinutes() < 10
          ? "0" + datetime.getMinutes()
          : datetime.getMinutes();
      var Nsecond =
        datetime.getSeconds() < 10
          ? "0" + datetime.getSeconds()
          : datetime.getSeconds();
      result = Nyear + "-" + Nmonth + "-" + Ndate;
    }
    return result;
    }
}