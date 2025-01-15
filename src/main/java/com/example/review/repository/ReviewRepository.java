package com.example.review.repository;

import com.example.review.dto.ReviewStatsDTO;
import com.example.review.entity.Review;
import com.example.review.enumeration.ReviewStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query(value = """
        SELECT r.* 
        FROM reviews r 
        INNER JOIN users u On r.user_id = u.id
        WHERE r.product_id = :productId
        AND r.status = 'APPROVED'
        ORDER BY r.created_at DESC 
        LIMIT 3
        """, nativeQuery = true)
    List<Review> findLastThreeReviewsByProductId(@Param("productId") Long productId);

    @Query("""
                SELECT new com.example.review.dto.ReviewStatsDTO(COUNT(r.id), COALESCE(AVG(r.rating), 0.0))
                FROM Review r 
                WHERE r.product.id = :productId
                AND r.status = 'APPROVED'
            """)
    ReviewStatsDTO findReviewStatsByProductId(@Param("productId") Long productId);

}