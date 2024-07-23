import mysql from "mysql2/promise";
import fetch from "node-fetch";
import dotenv from "dotenv";

dotenv.config();

const fetchData = async (page, size) => {
  const res = await fetch(
    `${process.env.BASE_URL}/board/v1/list?bbs_id=T2019-0286-04-296340&page=${page}&page_size=${size}&notice_yn=N&kbs_board_auth=0`
  );
  const data = await res.json();

  const posts = data.default_post;

  const validData = posts.map((post) => {
    const imageUrls = JSON.parse(post.post_cont_image);

    return {
      title: post.post_title,
      contents: post.post_contents,
      description: post.description,
      image: imageUrls ? imageUrls[0] : null,
    };
  });

  const connection = await mysql.createConnection({
    host: process.env.DB_HOST,
    user: process.env.DB_USER,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME,
    port: process.env.DB_PORT,
  });

  const insertQuery = `
      INSERT INTO recipe (title, contents, description, image)
      VALUES (?, ?, ?, ?)
      ON DUPLICATE KEY UPDATE
        title = VALUES(title),
        contents = VALUES(contents),
        description = VALUES(description),
        image = VALUES(image);
    `;

  for (const post of validData) {
    await connection.execute(insertQuery, [
      post.title,
      post.contents,
      post.description,
      post.image,
    ]);
  }

  console.log("데이터 넣기 성공 !!");

  await connection.end();
};

fetchData(18, 100);
