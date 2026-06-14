const {DataTypes} = require('sequelize');
const sequelize = require('../config/db');

const TipoUsuario = sequelize.define('TipoUsuario', {
    id: {
        type: DataTypes.INTEGER,
        primaryKey: true,
        autoIncrement: true
    },
    nombre: {
        type: DataTypes.STRING,
        allowNull: false
    }
}, {
    tableName: 'tipos_usuario',
    timestamps: false
});

module.exports = TipoUsuario;