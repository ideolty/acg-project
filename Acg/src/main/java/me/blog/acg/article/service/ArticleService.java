package me.blog.acg.article.service;

import me.blog.acg.article.model.ArticleViewModel;
import org.springframework.stereotype.Service;

@Service
public interface ArticleService {
    ArticleViewModel findById(Long id);

    ArticleViewModel detail(Long id);
}
