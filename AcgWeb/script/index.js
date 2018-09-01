

let data = {
    articles: [
        {
            title: "Spring core源码分析",
            href: "#",
            publishTime: "2018年8月24日",
            author: "iven",
            commentsNumber: "7",
            contentPictureHref: "static/img/NewBannerBOOTS_2.png",
            summary: "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can \"just run\".",
            topic: "java",
            tag: ["java", "Spring"]
        },
        {
            title: "Spring core源码分析",
            href: "#",
            publishTime: "2018年8月25日",
            author: "iven",
            commentsNumber: "7",
            contentPictureHref: "static/img/NewBannerBOOTS_2.png",
            summary: "Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can \"just run\".",
            topic: "java",
            tag: ["java", "Spring"]
        }
    ]
};

let page = new Vue({
    el: '#page',
    data: data,
    created: function () {
        // `this` 指向 vm 实例

    },
    methods: {
        //这里是自定义的方法
        test: function () {
            alert('test');
        }
    }
});
