-- user account
insert into user_account (user_id, user_password, nick_name, email, memo, created_at, created_by, modified_at, modified_by)
values ('hyeon', 'dummypassword', 'Hyeon', 'hyeon@mail.com', 'Hyeon', now(), 'hyeon', now(), 'hyeon');

-- article 11
insert into article(user_account_id, title, content, hashtag, created_by, created_at, modified_by, modified_at)
values (1, 'test1', 'content1', 'hashtag1', 'hyeon', '2022-01-12', 'hyeon', '2022-01-12'),
       (1, 'test2', 'content2', 'hashtag2', 'hyeon', '2022-01-13', 'hyeon', '2022-01-13'),
       (1, 'test3', 'content3', 'hashtag3', 'hyeon', '2022-01-14', 'hyeon', '2022-01-14'),
       (1, 'test4', 'content4', 'hashtag4', 'hyeon', '2022-01-15', 'hyeon', '2022-01-15'),
       (1, 'test5', 'content5', 'hashtag5', 'hyeon', '2022-01-16', 'hyeon', '2022-01-16'),
       (1, 'test6', 'content6', 'hashtag6', 'hyeon', '2022-01-17', 'hyeon', '2022-01-17'),
       (1, 'test7', 'content7', 'hashtag7', 'hyeon', '2022-01-18', 'hyeon', '2022-01-18'),
       (1, 'test8', 'content8', 'hashtag8', 'hyeon', '2022-01-19', 'hyeon', '2022-01-19'),
       (1, 'test9', 'content9', 'hashtag9', 'hyeon', '2022-01-20', 'hyeon', '2022-01-20'),
       (1, 'test10', 'content10', 'hashtag10', 'hyeon', '2022-01-21', 'hyeon', '2022-01-21');

-- article comment 15
insert into article_comment(article_id, user_account_id, content, created_by, created_at, modified_by, modified_at)
values  (1, 1, 'content1', 'hyeon', '2022-01-12', 'hyeon', '2022-01-12'),
        (2, 1, 'content2', 'hyeon', '2022-01-13', 'hyeon', '2022-01-13'),
        (3, 1, 'content3', 'hyeon', '2022-01-14', 'hyeon', '2022-01-14'),
        (4, 1, 'content4', 'hyeon', '2022-01-15', 'hyeon', '2022-01-15'),
        (5, 1, 'content5', 'hyeon', '2022-01-16', 'hyeon', '2022-01-16'),
        (6, 1, 'content6', 'hyeon', '2022-01-17', 'hyeon', '2022-01-17'),
        (7, 1, 'content7', 'hyeon', '2022-01-18', 'hyeon', '2022-01-18'),
        (8, 1, 'content8', 'hyeon', '2022-01-19', 'hyeon', '2022-01-19'),
        (9, 1, 'content9', 'hyeon', '2022-01-20', 'hyeon', '2022-01-20'),
        (10, 1, 'content10', 'hyeon', '2022-01-21', 'hyeon', '2022-01-21'),
        (1, 1, 'content11',  'hyeon', '2022-01-22', 'hyeon', '2022-01-22'),
        (2, 1, 'content12', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
        (2, 1, 'content13', 'hyeon', '2022-01-24', 'hyeon', '2022-01-24'),
        (3, 1, 'content14', 'hyeon', '2022-01-25', 'hyeon', '2022-01-25'),
        (3, 1, 'content15', 'hyeon', '2022-01-26', 'hyeon', '2022-01-26');