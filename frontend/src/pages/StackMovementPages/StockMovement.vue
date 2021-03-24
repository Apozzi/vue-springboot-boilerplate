<template>
  <div class="stock-movement">
    <h1>
      Movimentação estoque
    </h1>

    <b-card class="mt-4 mb-2">
      <div class="row m-2">
        <div class="col-md-6">
          <label for="input-live">Produto:</label>
          <b-form-input
            id="input-live"
            v-model="name"
            :state="nameState"
            placeholder="Produto"
            trim
          ></b-form-input>
        </div>
        <div class="col-md-6">
          <label for="input-live">Tipo do movimentação:</label>
          <b-form-select v-model="selected" :options="options"></b-form-select>
        </div>
      </div>
      <div class="row m-2">
        <div class="col-md-6">
          <label for="input-live">Valor venda:</label>
          <b-form-input
            id="input-live"
            v-model="name"
            :state="nameState"
            placeholder="Valor venda"
            type="number"
            trim
          ></b-form-input>
        </div>
        <div class="col-md-6">
          <label for="input-live">Data venda:</label>
          <b-form-datepicker id="data-venda" v-model="value" class="mb-2"></b-form-datepicker>
        </div>
      </div>
      <div class="row m-2">
        <div class="col-md-6">
          <label for="input-live">Quantidade movimentada:</label>
          <b-form-input
            id="input-live"
            v-model="name"
            :state="nameState"
            type="number"
            placeholder="Quantidade movimentada"
            trim
          ></b-form-input>
        </div>
      </div>
    </b-card>
    <b-card class="mt-2 mb-2">
      <b-btn variant="success" id="add" class="ml-2">Salvar</b-btn>
      <router-link :to="{ name: 'stock-movements' }">
        <b-btn id="edit" class="ml-2">Voltar</b-btn>
      </router-link>
    </b-card>
  </div>
</template>

<script>
export default {
  name: 'stock-movements',
  data() {
      return {
        selected: null,
        options: [
          { value: null, text: 'Selecione um tipo de movimentação', disabled: true },
          { value: 'E', text: 'Entrada' },
          { value: 'S', text: 'Saida' },
        ]
      }
  }
}
</script>

