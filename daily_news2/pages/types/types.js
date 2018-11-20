// pages/types/types.js
Page({
    //  从数据聚合中取出新闻
    getNewsList:function(kind){
       var that = this;
       wx.request({
           url: 'http://v.juhe.cn/toutiao/index',
           data:{
               key:"082153265794dc7a4bdb119e272319ee",
               type:kind
           },
           success:function(res){
               console.log(res)
               that.setData({
                   newsList:res.data.result.data
               });
           }
       });
    },
    selectType:function(e){
        this.getNewsList(e.target.id);
        this.setData({
            currentType: e.target.id
        });
       
    },
    /**
     * 页面的初始数据
     */
    data: {
        currentType:'top',
        newsList:[]
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {

    },

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
        this.getNewsList("top");
    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})