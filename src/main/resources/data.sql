INSERT INTO users (id, username, password, usertype, uuid)
VALUES (1,
        'admin',
        '$2y$10$pHLVYoOyBwp0K/Yyke2nJOFpXJJb3872izCNbcKeh1Go14/S1KYLC',
        'admin',
        '6374cd56-3ba8-11ec-8d3d-0242ac130003');
-- Login to UI is admin/password

INSERT INTO profiles (bio, pictureurl, address, firstname, lastname, rating, uid)
VALUES ('Hi My name is admin',
        'https://www.history.com/.image/ar_1:1%2Cc_fill%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_1200/MTU3ODc5MDgzNDc5NjcyNTQz/portrait-of-john-smith.jpg',
        'DePaul Chicago',
        'John',
        'Smith',
        5,
        '1');


