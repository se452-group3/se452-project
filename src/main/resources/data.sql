INSERT INTO users (id, username, password, usertype, uuid)
VALUES (0,
        'admin',
        '$2y$10$pHLVYoOyBwp0K/Yyke2nJOFpXJJb3872izCNbcKeh1Go14/S1KYLC',
        'admin',
        '6374cd56-3ba8-11ec-8d3d-0242ac130003');
-- Login to UI is admin/password

INSERT INTO profiles (bio, pictureurl, address, firstname, lastname, rating, uid)
VALUES ('Hi My name is admin',
        'https://cdn.britannica.com/04/171104-050-AEFE3141/Steve-Jobs-iPhone-2010.jpg',
        'DePaul Chicago',
        'John',
        'Smith',
        5,
        0);


