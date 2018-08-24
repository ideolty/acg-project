package me.blog.acg.article.service;

import me.blog.acg.article.domain.Article;
import me.blog.acg.article.model.ArticleViewModel;
import me.blog.acg.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public ArticleViewModel findById(Long id) {
        Optional<Article> articleOptional = articleRepository.findById(id);
        ArticleViewModel articleViewModel = new ArticleViewModel();
        if (articleOptional.isPresent()){
            Article article = articleOptional.get();
            BeanCopier copier = BeanCopier.create(Article.class, ArticleViewModel.class, false);
            copier.copy(article, articleViewModel, null);
        }
        return articleViewModel;
    }

    /**
     * 返回文章的所有细节
     * @param id
     * @return
     */
    @Override
    public ArticleViewModel detail(Long id) {
        /**
         * todo     文章包括了 评论等其他表信息。我打算存在另一个数据库中
         * 一次文章的细节查询，可能需要查多个数据库，这里没有必要顺序执行。所有的查询可以同步进行，在一个点等待就好了。只要有一个查询失败，
         * 那么这个方法就失败。查询结束后拼接成一个viewModel返回前端
         * 建个线程池。 线程实现一下callable接口
         */
        return null;
    }
}
