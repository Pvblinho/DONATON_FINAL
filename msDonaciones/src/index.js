const express = require('express');
const dotenv = require('dotenv');

dotenv.config();

const app = express();
app.use(express.json());

app.use('/auth', require('./routes/auth'));
app.use('/users', require('./routes/users.js'));


app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).json({ error: 'Error interno del servidor' });
});

const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`EL SERVIDOR ESTA CORRIENDO EN EL PUERTO ${PORT}`);
});
