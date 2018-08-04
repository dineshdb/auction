const express = require('express')
const httpProxy = require('http-proxy')
const path = require('path')

const apiServer = 'http://localhost:8080',
      recommendationServer = 'http://localhost:5000'

const app = express()
const apiProxy = httpProxy.createProxyServer()

app.use(express.static('public'))

app.all("/api/*", (req, res) => {
      req.url = req.url.replace("/api/", "/")
      console.log("Redirecting to api", req)
      apiProxy.web(req, res, { target: apiServer})
})

app.all("/recommend/*", (req, res) => {
      req.url = req.url.replace("/recommend/", "/")
      console.log("Redirecting to recommendor")
      apiProxy.web(req, res, { target: recommendationServer})
})

app.use(function (req, res, next) {
  res.status(200).sendFile(path.join(__dirname, 'public', 'index.html'))
})

app.listen(3000)
