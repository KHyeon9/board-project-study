-- user account
insert into user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by)
values ('hyeon', '{noop}dummypassword', 'Hyeon', 'hyeon@mail.com', 'Hyeon', now(), 'hyeon', now(), 'hyeon');

insert into user_account (user_id, user_password, nickname, email, memo, created_at, created_by, modified_at, modified_by)
values ('hyeon2', '{noop}dummypassword2', 'Hyeon2', 'hyeon2@mail.com', 'Hyeon2', now(), 'hyeon2', now(), 'hyeon2');

-- article 102
insert into article(user_id, title, content, hashtag, created_by, created_at, modified_by, modified_at)
values ('hyeon2', 'test1', 'content1', '#hashtag1', 'hyeon2', '2022-01-12', 'hyeon2', '2022-01-12'),
       ('hyeon', 'test2', 'content2', '#hashtag2', 'hyeon', '2022-01-13', 'hyeon', '2022-01-13'),
       ('hyeon', 'test3', 'content3', '#hashtag3', 'hyeon', '2022-01-14', 'hyeon', '2022-01-14'),
       ('hyeon', 'test4', 'content4', '#hashtag4', 'hyeon', '2022-01-15', 'hyeon', '2022-01-15'),
       ('hyeon', 'test5', 'content5', '#hashtag5', 'hyeon', '2022-01-16', 'hyeon', '2022-01-16'),
       ('hyeon', 'test6', 'content6', '#hashtag6', 'hyeon', '2022-01-17', 'hyeon', '2022-01-17'),
       ('hyeon', 'test7', 'content7', '#hashtag7', 'hyeon', '2022-01-18', 'hyeon', '2022-01-18'),
       ('hyeon', 'test8', 'content8', '#hashtag8', 'hyeon', '2022-01-19', 'hyeon', '2022-01-19'),
       ('hyeon', 'test9', 'content9', '#hashtag9', 'hyeon', '2022-01-20', 'hyeon', '2022-01-20'),
       ('hyeon', 'test10', 'content10', '#hashtag10', 'hyeon', '2022-01-21', 'hyeon', '2022-01-21'),
       ('hyeon', 'test11', 'content11', '#hashtag11', 'hyeon', '2022-01-22', 'hyeon', '2022-01-22'),
       ('hyeon', 'test12', 'content12', '#hashtag12', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
       ('hyeon', 'test13', 'content13', '#hashtag13', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
       ('hyeon2', 'test14', 'content14', '#hashtag14', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
       ('hyeon', 'test15', 'content15', '#hashtag15', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
       ('hyeon', 'test16', 'content16', '#hashtag16', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
       ('hyeon', 'test17', 'content17', '#hashtag17', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
       ('hyeon', 'test18', 'content18', '#hashtag18', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
       ('hyeon', 'test19', 'content19', '#hashtag19', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
       ('hyeon', 'test20', 'content20', '#hashtag20', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
       ('hyeon', 'test21', 'content21', '#hashtag21', 'hyeon', '2022-01-24', 'hyeon', '2022-01-24'),
       ('hyeon', 'test22', 'content22', '#hashtag22', 'hyeon', '2022-01-24', 'hyeon', '2022-01-24'),
       ('hyeon', 'test23', 'content23', '#hashtag23', 'hyeon', '2022-01-25', 'hyeon', '2022-01-25'),
       ('hyeon', 'test24', 'content24', '#hashtag24', 'hyeon', '2022-01-25', 'hyeon', '2022-01-25'),
       ('hyeon', 'test25', 'content25', '#hashtag25', 'hyeon', '2022-01-26', 'hyeon', '2022-01-26'),
       ('hyeon', 'test26', 'content26', '#hashtag26', 'hyeon', '2022-01-26', 'hyeon', '2022-01-26'),
       ('hyeon', 'test27', 'content27', '#hashtag27', 'hyeon', '2022-01-27', 'hyeon', '2022-01-27'),
       ('hyeon', 'test28', 'content28', '#hashtag28', 'hyeon', '2022-01-27', 'hyeon', '2022-01-27'),
       ('hyeon', 'test29', 'content29', '#hashtag29', 'hyeon', '2022-01-28', 'hyeon', '2022-01-28'),
       ('hyeon', 'test30', 'content30', '#hashtag30', 'hyeon', '2022-01-28', 'hyeon', '2022-01-28'),
       ('hyeon', 'test31', 'content31', '#hashtag31', 'hyeon', '2022-01-29', 'hyeon', '2022-01-29'),
       ('hyeon', 'test32', 'content32', '#hashtag32', 'hyeon', '2022-01-29', 'hyeon', '2022-01-29'),
       ('hyeon', 'dummytitle1', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle2', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle3', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle4', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle5', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle6', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle7', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle8', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle9', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle10', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle11', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-01', 'hyeon', '2022-02-01'),
       ('hyeon', 'dummytitle12', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-02', 'hyeon', '2022-02-02'),
       ('hyeon', 'dummytitle13', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-02', 'hyeon', '2022-02-02'),
       ('hyeon', 'dummytitle14', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-02', 'hyeon', '2022-02-02'),
       ('hyeon', 'dummytitle15', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-02', 'hyeon', '2022-02-02'),
       ('hyeon', 'dummytitle16', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-03', 'hyeon', '2022-02-03'),
       ('hyeon', 'dummytitle17', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-03', 'hyeon', '2022-02-03'),
       ('hyeon', 'dummytitle18', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-03', 'hyeon', '2022-02-03'),
       ('hyeon', 'dummytitle19', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-03', 'hyeon', '2022-02-03'),
       ('hyeon', 'dummytitle20', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-03', 'hyeon', '2022-02-03'),
       ('hyeon', 'dummytitle21', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-03', 'hyeon', '2022-02-03'),
       ('hyeon', 'dummytitle22', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-03', 'hyeon', '2022-02-03'),
       ('hyeon', 'dummytitle23', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-03', 'hyeon', '2022-02-03'),
       ('hyeon', 'dummytitle24', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-03', 'hyeon', '2022-02-03'),
       ('hyeon', 'dummytitle25', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-04', 'hyeon', '2022-02-04'),
       ('hyeon', 'dummytitle26', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-04', 'hyeon', '2022-02-04'),
       ('hyeon', 'dummytitle27', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-04', 'hyeon', '2022-02-04'),
       ('hyeon', 'dummytitle28', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-04', 'hyeon', '2022-02-04'),
       ('hyeon', 'dummytitle29', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-04', 'hyeon', '2022-02-04'),
       ('hyeon', 'dummytitle30', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-04', 'hyeon', '2022-02-04'),
       ('hyeon', 'dummytitle31', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-04', 'hyeon', '2022-02-04'),
       ('hyeon', 'dummytitle32', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-04', 'hyeon', '2022-02-04'),
       ('hyeon', 'dummytitle33', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-04', 'hyeon', '2022-02-04'),
       ('hyeon', 'dummytitle34', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle35', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle36', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle37', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle38', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle39', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle40', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle41', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle42', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle43', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle44', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-05', 'hyeon', '2022-02-05'),
       ('hyeon', 'dummytitle45', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-06', 'hyeon', '2022-02-06'),
       ('hyeon', 'dummytitle46', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-06', 'hyeon', '2022-02-06'),
       ('hyeon', 'dummytitle47', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-06', 'hyeon', '2022-02-06'),
       ('hyeon', 'dummytitle48', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-06', 'hyeon', '2022-02-06'),
       ('hyeon', 'dummytitle49', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-07', 'hyeon', '2022-02-07'),
       ('hyeon', 'dummytitle50', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-07', 'hyeon', '2022-02-07'),
       ('hyeon', 'dummytitle51', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-07', 'hyeon', '2022-02-07'),
       ('hyeon', 'dummytitle52', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-07', 'hyeon', '2022-02-07'),
       ('hyeon', 'dummytitle53', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-07', 'hyeon', '2022-02-07'),
       ('hyeon', 'dummytitle54', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-07', 'hyeon', '2022-02-07'),
       ('hyeon', 'dummytitle55', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-07', 'hyeon', '2022-02-07'),
       ('hyeon', 'dummytitle56', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-07', 'hyeon', '2022-02-07'),
       ('hyeon', 'dummytitle57', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-08', 'hyeon', '2022-02-08'),
       ('hyeon', 'dummytitle58', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-08', 'hyeon', '2022-02-08'),
       ('hyeon', 'dummytitle59', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-08', 'hyeon', '2022-02-08'),
       ('hyeon2', 'dummytitle60', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon2', '2022-02-08', 'hyeon2', '2022-02-08'),
       ('hyeon', 'dummytitle61', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-08', 'hyeon', '2022-02-08'),
       ('hyeon', 'dummytitle62', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-08', 'hyeon', '2022-02-08'),
       ('hyeon2', 'dummytitle63', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon2', '2022-02-09', 'hyeon2', '2022-02-09'),
       ('hyeon2', 'dummytitle64', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon2', '2022-02-09', 'hyeon2', '2022-02-09'),
       ('hyeon', 'dummytitle65', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon', '2022-02-09', 'hyeon', '2022-02-09'),
       ('hyeon2', 'dummytitle66', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon2', '2022-02-10', 'hyeon2', '2022-02-10'),
       ('hyeon2', 'dummytitle67', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon2', '2022-02-10', 'hyeon2', '2022-02-10'),
       ('hyeon2', 'dummytitle68', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon2', '2022-02-10', 'hyeon2', '2022-02-10'),
       ('hyeon2', 'dummytitle69', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon2', '2022-02-10', 'hyeon2', '2022-02-10'),
       ('hyeon2', 'dummytitle70', 'dummy content....dummy content....dummy content...', '#dummy', 'hyeon2', '2022-02-11', 'hyeon2', '2022-02-11');

-- article comment 26
insert into article_comment (article_id, user_id, content, created_by, created_at, modified_by, modified_at)
values  (1, 'hyeon2', 'content1', 'hyeon2', '2022-01-12', 'hyeon2', '2022-01-12'),
        (2, 'hyeon2', 'content2', 'hyeon2', '2022-01-13', 'hyeon2', '2022-01-13'),
        (3, 'hyeon2', 'content3', 'hyeon2', '2022-01-14', 'hyeon2', '2022-01-14'),
        (4, 'hyeon2', 'content4', 'hyeon2', '2022-01-15', 'hyeon2', '2022-01-15'),
        (5, 'hyeon', 'content5', 'hyeon', '2022-01-16', 'hyeon', '2022-01-16'),
        (6, 'hyeon', 'content6', 'hyeon', '2022-01-17', 'hyeon', '2022-01-17'),
        (7, 'hyeon', 'content7', 'hyeon', '2022-01-18', 'hyeon', '2022-01-18'),
        (8, 'hyeon', 'content8', 'hyeon', '2022-01-19', 'hyeon', '2022-01-19'),
        (9, 'hyeon', 'content9', 'hyeon', '2022-01-20', 'hyeon', '2022-01-20'),
        (10, 'hyeon2', 'content10', 'hyeon2', '2022-01-21', 'hyeon2', '2022-01-21'),
        (1, 'hyeon2', 'content11',  'hyeon2', '2022-01-22', 'hyeon2', '2022-01-22'),
        (2, 'hyeon', 'content12', 'hyeon', '2022-01-23', 'hyeon', '2022-01-23'),
        (2, 'hyeon2', 'content13', 'hyeon', '2022-01-24', 'hyeon', '2022-01-24'),
        (3, 'hyeon', 'content14', 'hyeon', '2022-01-25', 'hyeon', '2022-01-25'),
        (3, 'hyeon', 'content15', 'hyeon', '2022-01-25', 'hyeon', '2022-01-25'),
        (3, 'hyeon', 'content16', 'hyeon', '2022-01-25', 'hyeon', '2022-01-25'),
        (3, 'hyeon2', 'content17', 'hyeon2', '2022-01-26', 'hyeon2', '2022-01-26'),
        (3, 'hyeon2', 'content18', 'hyeon2', '2022-01-26', 'hyeon2', '2022-01-26'),
        (3, 'hyeon2', 'content19', 'hyeon2', '2022-01-26', 'hyeon2', '2022-01-26'),
        (102, 'hyeon2', 'content20', 'hyeon2', '2022-01-26', 'hyeon2', '2022-01-26'),
        (102, 'hyeon', 'content21', 'hyeon', '2022-01-27', 'hyeon', '2022-01-27'),
        (102, 'hyeon2', 'content22', 'hyeon2', '2022-01-27', 'hyeon2', '2022-01-27'),
        (102, 'hyeon', 'content23', 'hyeon', '2022-01-28', 'hyeon', '2022-01-28'),
        (102, 'hyeon2', 'content24', 'hyeon2', '2022-01-28', 'hyeon2', '2022-01-28'),
        (102, 'hyeon', 'content25', 'hyeon', '2022-01-29', 'hyeon', '2022-01-29'),
        (102, 'hyeon2', 'content26', 'hyeon2', '2022-01-29', 'hyeon2', '2022-01-29');