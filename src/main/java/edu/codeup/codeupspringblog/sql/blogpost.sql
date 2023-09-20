use blog_db;
INSERT INTO user (username, password, email) VALUES
                                                  ('user1', 'password1', 'user1@example.com'),
                                                  ('user2', 'password2', 'user2@example.com'),
                                                  ('user3', 'password3', 'user3@example.com'),
                                                  ('user4', 'password4', 'user4@example.com'),
                                                  ('user5', 'password5', 'user5@example.com');
INSERT INTO blog_post (title, body, user_id) VALUES
                                                  ('Post 1 Title', 'This is the body of Post 1.', 1),
                                                  ('Post 2 Title', 'This is the body of Post 2.', 2),
                                                  ('Post 3 Title', 'This is the body of Post 3.', 3),
                                                  ('Post 4 Title', 'This is the body of Post 4.', 4),
                                                  ('Post 5 Title', 'This is the body of Post 5.', 5);